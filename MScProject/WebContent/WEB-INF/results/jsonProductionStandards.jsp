<%@ page import = "com.google.gson.Gson"%>
<%@ page import = "modelProductionStandard.ProductionStandard"%>
<%@ page import = "modelProductionStandard.ProductionStandardDAO"%>
<%@ page import = "java.util.ArrayList"%>

<%
ArrayList<ProductionStandard> allProductionStandards = (ArrayList<ProductionStandard>) request.getAttribute("ProductionStandards");
Gson gson = new Gson();
String ProductionStandardJson = gson.toJson(allProductionStandards);
out.println(ProductionStandardJson);
%>
