package com.reservation.management.payload;

public class Response {

	 private String message;
	  //  private String fileDownloadUri;
	   // private String fileType;
	   // private long size;
	    
	    

//	    public Response() {
//			
//		}
//
//		public Response(String fileName, String fileDownloadUri, long size) {
//	        this.fileName = fileName;
//	        this.fileDownloadUri = fileDownloadUri;
//	      //  this.fileType = fileType;
//	        this.size = size;
//	    }


		public String getMessage() {
	        return message;
	    }

	    public Response(String message) {
		
		this.message = message;
	}

		public void setMessage(String  message) {
	        this.message=  message;
	    }

//	    public String getFileDownloadUri() {
//	        return fileDownloadUri;
//	    }
//
//	    public void setFileDownloadUri(String fileDownloadUri) {
//	        this.fileDownloadUri = fileDownloadUri;
//	    }

//	    public String getFileType() {
//	        return fileType;
//	    }

//	    public void setFileType(String fileType) {
//	        this.fileType = fileType;
//	    }

//	    public long getSize() {
//	        return size;
//	    }
//
//	    public void setSize(long size) {
//	        this.size = size;
//	    }
}
