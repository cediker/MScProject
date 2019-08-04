<%@ page import = "com.google.gson.Gson"%>
<%@ page import = "modelTestResult.TestResult"%>
<%@ page import = "java.util.ArrayList"%>

<%
ArrayList<TestResult> allTestResults = (ArrayList<TestResult>) request.getAttribute("TestResults");
Gson gson = new Gson();
String testResultJson = gson.toJson(allTestResults);
out.println(testResultJson);
%>