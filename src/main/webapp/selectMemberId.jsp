<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dao.*"%>
<%@page import="com.google.gson.Gson"%>
<%
	System.out.println(request.getParameter("idck"));
	String idck = request.getParameter("idck");
	MemberDao dao = new MemberDao();
	String result = dao.selectMemberId(idck); // Y, N
	System.out.println(result);
	
	Gson gson = new Gson();
	// 자바객체변수값을 JSON문자열로 변경해주는 API
	String jsonStr = gson.toJson(result);
	
	out.print(jsonStr);
%>
