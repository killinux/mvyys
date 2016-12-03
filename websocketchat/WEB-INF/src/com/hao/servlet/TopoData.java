package com.hao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hao.HelloWorldWebSocketServlet;

import net.sf.json.JSONObject;



public class TopoData extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sssssssssssss");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//Topo topo = new Topo();
		//topo.getTopo();
		JSONObject myjson=new JSONObject().fromObject("{processes:"+HelloWorldWebSocketServlet.processes.toString()+",connections:"+HelloWorldWebSocketServlet.connections.toString()+",errornodes:"+HelloWorldWebSocketServlet.errornodes.toString()+"}");

		out.println(myjson);

		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
}
