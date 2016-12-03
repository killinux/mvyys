package com.hao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo {
	//public static JSONObject network= new JSONObject().fromObject("{processes:{},	connections:[]}");
	public static JSONObject processes= new JSONObject().fromObject("{}");
	public static JSONArray connections= new JSONArray().fromObject("[]");
	public static void main(String[] args) {
		//String messages="\"network111\":{\"component\":\"network111\",\"metadata\":{\"type\":\"cloud\",\"vm_id\":\"network111\",\"vm_status\":\"TRUE\",\"x\":10,\"y\":50,\"width\":72,\"label\":\"网络\"}}";
		JSONObject aaaa=new JSONObject().fromObject("{processes:"+processes.toString()+",connections:"+connections.toString()+"}");

		System.out.println(aaaa.toString());

	}

}
