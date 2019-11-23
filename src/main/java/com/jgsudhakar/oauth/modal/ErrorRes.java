package com.jgsudhakar.oauth.modal;

import java.io.Serializable;

/**
 * @author sudhakar.t
 *
 */
public class ErrorRes implements Serializable {

   private static final long serialVersionUID = 1L;

   private Integer status;

   private Object error;

   private String error_description;

   public ErrorRes() {

   }

   public ErrorRes(Object code, String message) {
      setCode(code);
      setMessage(message);
   }

   public ErrorRes(Integer status, Object code, String message) {
      setCode(code);
      setMessage(message);
      setStatus(status);
   }

   /**
    * @return the status
    */
   public Integer getStatus() {
      return status;
   }

   /**
    * @param status
    *           the status to set
    */
   public void setStatus(Integer status) {
      this.status = status;
   }

   /**
    * @return the message
    */
   public String getMessage() {
      return error_description;
   }

   /**
    * @param message
    *           the message to set
    */
   public void setMessage(String message) {
      this.error_description = message;
   }

   /**
    * @return the code
    */
   public Object getCode() {
      return error;
   }

   /**
    * @param code
    *           the code to set
    */
   public void setCode(Object code) {
      this.error = code;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "ErrorRes [status=" + status + ", error=" + error + ", error_description=" + error_description + "]";
   }

}
