<%@ page import = "com.google.gson.Gson"%>
<%@ page import = "modelTestMethod.TestMethod"%>
<%@ page import = "java.util.ArrayList"%>

<%
ArrayList<TestMethod> allTestMethods = (ArrayList<TestMethod>) request.getAttribute("TestMethods");
Gson gson = new Gson();
String TestMethodJson = gson.toJson(allTestMethods);
out.println(TestMethodJson);
%>