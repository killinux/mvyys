<%@ page language="java" import="java.sql.*,java.util.*,net.sf.json.JSONArray,com.hao.HelloWebSocketServlet" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<!--[if IE 8]>         <html class="no-js lt-ie9"> </html><![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>face</title>

</head>
<body style=" background:#FFFFFF; margin:0; padding:0; padding-bottom:55px">
<%
	Map map=com.hao.HelloWebSocketServlet.mmiList;	
out.print(map.size());

Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();  
while (iterator.hasNext()) {  
    Map.Entry<Integer, String> entry = iterator.next();  
    System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue());  
}
%>
</body>
</html> 
      
