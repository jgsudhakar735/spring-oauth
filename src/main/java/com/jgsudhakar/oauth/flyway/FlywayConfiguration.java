/**
 * 
 */
package com.jgsudhakar.oauth.flyway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sudhakar.t
 *
 */
@Slf4j
public class FlywayConfiguration extends Flyway{
	

	@Autowired
	private Environment environment;
	
	/**
	   * Set this to a particular version if you need Flyway to skip execution of SQL scripts with versions up to this given version.
	   * For example, if "12.3" is given, Flyway will skip versions below 12.3 (inclusive) and execute from version 12.3.1 up. 
	   * This property is useful when the database environment is already at a certain version (which we refer to as the baseline version).
	   * */
	  private final String BASE_LINE_VERSION = "0";

	  /**
	   * External API Base Version
	   * */
	  private final String EXTERNAL_BASE_LINE_VERSION = "0";
	
	 /**
	 *This will be the Table name which is override with the flyway  Table name (schema_version); Hereafter all the scripts versioning will be 
	 * logged in the below table .
	 * <pre>{@code Flyway#setTable(String)} Default will be "schema_version"</pre>
	 */
	private final String TABLE_NAME= "OAUTH_VERSION_HISTORY";
	
	
	/**
	 * This will be used when the project/service team should run their scripts by flyway . Here we are maintaining the separate table as it will fail if any 
	 * version is same with Defauly Schema version or the version is lower than the already executed version.
	 */
	private final String EXTERNAL_SCHEMA_TABLE = "MXCM_EXT_SCHEMA_VERSION";
	  
	/**
	 * This method will be used to check the any database scripts has been changed or not. If any database scripts changed then it will add the 
	 * version in the flyway version (schema_version) table and will apply the changes to the Database.
	 * @throws NamingException 
	 */
	public void version()  {

	      log.info("[version] Initializing database versioning check.");
	      
	      
	      if (getDataSource() == null) {
	    	  log.info("[version] Skipping database versioning check, dataSource is undefined.");
	         return;
	      }
	      // this.clean();
	      try {
	    	  	 setDataSource(getDataSource());   
	    	  	 setTable(TABLE_NAME); // override the default Table Name
	    	  	 String location = determineLocation();
		         setBaselineDescription("<< OAUTH API BASE LINE SCRIPT >>"); // override Default Baseline Desc
		         setLocations(location);
		         setBaselineOnMigrate(true);
		         setBaselineVersionAsString(BASE_LINE_VERSION);
		         setValidateOnMigrate(false);
		         int migrations = migrate();
		         log.info("[version] Completed database versioning, location = " + location + ", total migrations = " + migrations );
//		         
		      } catch (Exception e) {
	         log.warn("[version] Exception: " + e);
	         if (log.isInfoEnabled())
	            e.printStackTrace();
	      }
		
	}
	
	/**
	 * <pre>
	 * This method will determine the location of the scripts and will pick the respective scripts based on the database .
	 * Currently supported databases are
	 * <strong>
	 * 1. MYSQL
	 * 2. ORACLE
	 * 3. SQLSERVER
	 * </strong>  
	 * If none of the drive found, it will return the default scripts from <strong>oracle</strong>
	 * @return
	 * </pre>
	 */
	private String determineLocation() {
	      String driverName = null;
	      try {
	         driverName = getDataSource().getConnection().getMetaData().getDriverName().toLowerCase();
	      } catch (Exception e) {
	         log.warn("[determineLocation] Exceptions:driver name not found " + e);
	         e.printStackTrace();
	      }
	      StringBuilder str = new StringBuilder("classpath:/db/migration/");
	      String dbServerName = "";
	      if (driverName != null && driverName.contains("mysql")){
	         str.append("mysql/");
	         dbServerName = "MYSQL";
	      } else if (driverName != null && (driverName.contains("sql server") || driverName.contains("sqlserver"))){
	    	  str.append("sqlserver/");
	    	  dbServerName = "MS SQLSERVER";
	      }else{
	    	  str.append("oracle/");
	    	  dbServerName = "ORACLE";
	      }
	      
	      String location = str.toString();
	      
	      log.info("DataBase Server: "+dbServerName);
	      log.info("Driver Name = " + driverName );
	      log.info("Script Location = " + location);
	      log.info("Schema Table Name = "+getTable());
	      
	      return location;
	   }
	
	/**
	 * This method will execute the Scripts if any external script added to flyway; 
	 *  <pre>
	 *  Configuration as follows.
	 *  This method will look the external path in the  "MXCM_CONFIGURATION_STB" on the below criteria.
	 *   <i>
	 *   COLUMN NAME AND VALUE
	 *   CODE as 'FLYWAY' 
	 *   COMP_TYPE as DATABASE 
	 *   MERCHANT_ID as '1' 
	 *   VALUE as External Path (Ex: D:\FLYWAYSCRIPTS)
	 *   </i>
	 *  </pre> 
	 *  <i>
	 *  Note: Once External path configured should not be deleted or should not do any modification in the already executed scripts. If , it will be leading to 
	 *  the migration issue.
	 *  </i>
	 */
	@SuppressWarnings("unused")
	private void executeExternalScriptIfConfigured() {
		log.info("CHECKING FOR EXTERNAL SCRIPT CONFIGURATION");
		// getting the whether the Data Configured or not;
		Connection connection = null;
		PreparedStatement statement = null;
		String QUERY = "SELECT VALUE FROM MXCM_CONFIGURATION_STB WHERE COMP_TYPE = ? AND CODE = ? AND MERCHANT_ID = ?";
		String EXTERNAL_PATH = "";
		
		try {
			DataSource dataSource = getDataSource();
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(QUERY);
			statement.setString(1, "DATABASE");
			statement.setString(2, "FLYWAY");
			statement.setString(3, "1");
			ResultSet resultSet = statement.executeQuery();
			if(null != resultSet) {
				while (resultSet.next()) {
					EXTERNAL_PATH = resultSet.getString("VALUE");
					log.info("External Path ::>"+EXTERNAL_PATH);
				}
			}
			
			if(!StringUtils.isEmpty(EXTERNAL_PATH)) {
				// re- initialize the location
		        setTable(EXTERNAL_SCHEMA_TABLE); // override the default Table Name
		        setBaselineDescription("<< MX COMPONENT EXTERNAL BASE LINE SCRIPT >>"); // override Default Baseline Desc
				setLocations("filesystem:/"+EXTERNAL_PATH);
                setBaselineOnMigrate(true);
		        setBaselineVersionAsString(EXTERNAL_BASE_LINE_VERSION);
		        setValidateOnMigrate(true);
		        
			    log.info("External Schema Table Name = "+getTable());
		        
				int migrations = migrate();
		         log.info("[version] Completed database versioning, location = " + EXTERNAL_PATH + ", total migrations = " + migrations );
			}
			
			if(StringUtils.isEmpty(EXTERNAL_PATH))
				log.info("No External Script Configured, Not executing any external Script");
		} catch (SQLException e) {
			if(log.isInfoEnabled())
			e.printStackTrace();
			
		}finally {
			if(null != statement)
				try {
					statement.close();
				} catch (SQLException e1) {
					if(log.isInfoEnabled())
						e1.printStackTrace();
				}
			
			if(null != connection)
				try {
					connection.close();
				} catch (SQLException e) {
					if(log.isInfoEnabled())
					e.printStackTrace();
				}
		}
		
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}


}
