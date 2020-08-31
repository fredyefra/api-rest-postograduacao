package br.com.rest.fab.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	private String status;
	private String msg;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}

	public static Response OK(String string) {
		Response response = new Response();
		response.setStatus("OK");
		response.setMsg(string);
		return response;	
	}

	public static Response Error(String string) {
		Response response = new Response();
		response.setStatus("ERROR");
		response.setMsg(string);
		return response;	
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}