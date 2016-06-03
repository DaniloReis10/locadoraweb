package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

public class Controller {

	public HttpServletRequest request;
	public HttpServletResponse response;
	public HttpSession session;
	JSONObject retorno = new JSONObject();


	public Controller(HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		this.session = request.getSession();

		response.setContentType("text/x-json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
	}

}