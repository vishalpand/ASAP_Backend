package com.spring.asap.util;



public class ServiceResponse {

	private Object serviceResponse;
	private String serviceStatus;
	private Object serviceError;

	public static final String STATUS_FAIL = "Fail";
	public static final String STATUS_SUCCESS = "Success";

	public ServiceResponse() {
		super();
	}

	public ServiceResponse(Object serviceResponse, String serviceStatus, Object serviceError) {
		super();
		this.serviceResponse = serviceResponse;
		this.serviceStatus = serviceStatus;
		this.serviceError = serviceError;
	}

	public Object getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(Object serviceResponse) {
		if (serviceResponse == null) {
			this.serviceResponse = "";
		}
		this.serviceResponse = serviceResponse;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		if (serviceStatus == null) {
			this.serviceStatus = "Fail";
		}
		this.serviceStatus = serviceStatus;
	}

	public Object getServiceError() {
		return serviceError;
	}

	public void setServiceError(Object serviceError) {
		if (serviceError == null) {
			this.serviceError = "";
		}
		this.serviceError = serviceError;
	}

}
