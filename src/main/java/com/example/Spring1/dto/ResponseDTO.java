package com.example.Spring1.dto;

public class ResponseDTO<T> {
	
	public String status;
	public T data;
	public void ResponseDTO() {
		
	}
	public ResponseDTO(String status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseDTO [status=" + status + ", data=" + data + "]";
	}
	
}
