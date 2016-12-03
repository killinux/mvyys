package com.hao;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTMLDocument.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

public class HelloWorldWebSocketServlet extends WebSocketServlet {
	public static Map<String,MyMessageInbound> mmiList  = new HashMap<String,MyMessageInbound>();
	//public static Map<String,MyMessageInbound> mmiList  = new HashMap<String,MyMessageInbound>();
	//public static JSONObject network= new JSONObject().fromObject("{processes:{},	connections:[]}");
	public static JSONObject processes= new JSONObject().fromObject("{\"network111\":{\"component\":\"network111\",\"metadata\":{\"type\":\"cloud\",\"vm_id\":\"network111\",\"vm_status\":\"TRUE\",\"x\":500,\"y\":100,\"width\":72,\"label\":\"10.0.2.1\"}}}}");
	public static JSONArray connections= new JSONArray().fromObject("[]");
	public static JSONArray errornodes= new JSONArray().fromObject("[]");
	public static List<String> allnodes=new ArrayList<String>();
	//JSONObject pro=new JSONObject().fromObject(msg);
	//processes.put("network111", msg);
	
	protected StreamInbound createWebSocketInbound(String subProtocol,
			HttpServletRequest arg1) {
		System.out.println("hello world websocket");
		return new MyMessageInbound();
	}
	public int getUserCount(){
		return mmiList.size();
	}
	private class MyMessageInbound extends MessageInbound {
		WsOutbound myoutbound;
		String mykey;
		@Override
		public void onOpen(WsOutbound outbound) {
			try {
				System.out.println("Open Client.");
				this.myoutbound = outbound;
				mykey =""+System.currentTimeMillis();;
				mmiList.put(mykey, this);
				System.out.println("mmiList size:"+mmiList.size());
				outbound.writeTextMessage(CharBuffer.wrap("open "+mykey));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onClose(int status) {
			System.out.println("Close Client.");
			//mmiList.remove(this);
			mmiList.remove(mykey);
		}

		@Override
		protected void onBinaryMessage(ByteBuffer arg0) throws IOException {

		}
		private void toOne(CharBuffer message) throws IOException{
			System.out.println("onText--->" + message.toString());
			
			String[] msgarray= message.toString().split(",");
			if("".equals(msgarray[1])){
				for (Map.Entry<String, MyMessageInbound> entry : mmiList.entrySet()) {
					System.out.println("entry.getKey()-----"+entry.getKey());
					  MyMessageInbound mmib = (MyMessageInbound) entry.getValue(); 
					  CharBuffer buffer = CharBuffer.wrap(message);
					  System.out.println(buffer);
		              mmib.myoutbound.writeTextMessage(buffer);
		              mmib.myoutbound.flush();
				}
			}else{
				MyMessageInbound toUser=mmiList.get(msgarray[1]);
				if(toUser!=null){
					CharBuffer buffer = CharBuffer.wrap(message);
					toUser.myoutbound.writeTextMessage(buffer);
					toUser.myoutbound.flush();
				}
			}	
		}
		@Override
		protected void onTextMessage(CharBuffer message) throws IOException {
		    System.out.println("ddddddddddddddddf");
		    //String stringaa=message.toString();
			//JSONObject pro=new JSONObject().fromObject(messages);
			
			
			try {
				System.out.println("q11111111111111");//print messages not gif
				//String[] messages=message.toString().split("#");
				String[] messages=message.toString().split("#");
				
				//JSONObject pro=new JSONObject().fromObject(msg);
				System.out.println("2222222222");
				System.out.print(messages[0]);
				
				//Iterator it=(Iterator) allnodes.iterator();
			/*for(String tmp:allnodes){
				if(tmp==messages[1]){
					
				}
			}*/
				
				if(messages.length==4){
					System.out.println("44444444");
					allnodes.add(messages[0]);
					int i=0;
					for(i=0;i<allnodes.size();i++){
						if(allnodes.get(i)==messages[1]){
							break;
						}
					}
					if(i<allnodes.size()){
						return;
					}
					//String msg="{\"component\":\"server\",\"metadata\":{\"type\":\"server\",\"vm_id\":\""+messages[1]+"\",\"vm_status\":\"TRUE\",\"x\":10,\"y\":50,\"width\":72,\"label\":\""+messages[2]+"\"}}";
					String msg="{\"component\":\""+messages[3]+"\",\"metadata\":{\"type\":\""+messages[3]+"\",\"vm_id\":\""+messages[1]+"\",\"vm_status\":\"TRUE\",\"x\":10,\"y\":50,\"width\":72,\"label\":\""+messages[2]+"\"}}";
					processes.put(messages[1], msg);
					String conn="{\"src\":{\"process\":\"network111\",\"port\":\"out\"},\"tgt\":{\"process\":\""+messages[1]+"\",\"port\":\"in\"},\"metadata\":{\"route\":\"7\"}}";
					connections.add(conn);
				}else if(messages.length==2){
					System.out.println("2222222224442");
					System.out.println(messages[0]);
					if("warning".equals(messages[0])){
						System.out.println("zouhy");
						errornodes.add(messages[1]);
						
					}else if("quxiao".equals(messages[0])){
						System.out.println("hn");
						errornodes.remove(messages[1]);
					}
					
				}
				 
				
				//connection todo.....
				
				//String log_message=messages[0]+" say to "+messages[1]+":"+messages[2];
				//System.out.println("onText---> onTextMessage:"+messages.toString());
				//System.out.println("onText---> onTextMessage:"+messages.toString());
			} catch (Exception e) {
			}
			//String[] msgarray= stringaa.toString().split("#");
			for (Map.Entry<String, MyMessageInbound> entry : mmiList.entrySet()) {
				  //System.out.println(entry.getKey()+"-----");
				  MyMessageInbound mmib = (MyMessageInbound) entry.getValue(); 
				  CharBuffer buffer = CharBuffer.wrap(message+"#"+errornodes.toString());
				  //System.out.println(buffer);
	              mmib.myoutbound.writeTextMessage(buffer);
	              mmib.myoutbound.flush();
			}
			
			/*Socket socket;
			String msg = "";
			try {
				socket = new Socket("192.168.0.102", 5000);
				// socket = new Socket("127.0.0.1",5000);
				PrintWriter output = new PrintWriter(socket.getOutputStream());

				output.write(message.toString());
				output.flush();

				DataInputStream input = new DataInputStream(
						socket.getInputStream());
				byte[] b = new byte[1024];
				input.read(b);
				msg = new String(b).trim();

				output.close();
				input.close();
				socket.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CharBuffer cb = CharBuffer.wrap(new StringBuilder(msg));
			getWsOutbound().writeTextMessage(cb);*/
		}
	}

	public static void main(String[] args) {
		
		
		
		/*Socket socket;
		String message = "haoning";
		String msg = "";
		try {
			socket = new Socket("192.168.0.102", 5000);
			// socket = new Socket("127.0.0.1",5000);
			PrintWriter output = new PrintWriter(socket.getOutputStream());

			output.write(message.toString());
			output.flush();

			DataInputStream input = new DataInputStream(socket.getInputStream());
			byte[] b = new byte[1024];
			input.read(b);
			msg = new String(b).trim();

			output.close();
			input.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
