<%@ page import = "com.google.gson.Gson"%>
<%@ page import = "model.TestResult"%>
<%@ page import = "modelDAO.testResultDAO"%>
<%@ page import = "java.util.ArrayList"%>

<%
ArrayList<TestResult> allTestResults = (ArrayList<TestResult>) request.getAttribute("TestResults");
Gson gson = new Gson();
String testResultJson = gson.toJson(allTestResults);
out.println(testResultJson);
%>