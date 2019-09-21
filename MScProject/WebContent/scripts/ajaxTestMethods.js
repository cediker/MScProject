$(document).ready(function() {
});

//button reference: btn-test-methods
$(function() {
	$('#btn-test-methods').click(function() {
		getAllTestMethods();
	});
});

//add test method
$(function() {
	$("#btn-add-testMethod").click(function() {
		var testMethod = $('#formAddTestMethod').serialize();
		addTestMethod(testMethod);
		
	});
});

//delete test method
$(function() {
	$("#btn-delete-testMethod").click(function() {
		var testMethod = $('#deleteTestMethod').serialize();
		deleteTestMethod(testMethod);
		
	});
});




//method: getAllTestMethods
function getAllTestMethods() {
	
	$.ajax({
				url : "getAllTestMethods",
				success : function(result) {
				var div = "#demo";
				constructTable(result, div);
				}
	});
	}


//method: addTestMethod
	function addTestMethod(testMethod) {
	$.ajax({
		url: "addTestMethodServlet?testMethod=",
		data: testMethod,
		success: function(result) {
			$('#demo').text(result);
		}
	});
}
	
	//method: deleteTestMethod
	function deleteTestMethod(testMethod) {
	$.ajax({
		url: "deleteTestMethodServlet",
		data: testMethod,
		success: function(result) {
		}
	});
}
	


//method: constructTable
function constructTable(result, div){
	var table = '';
	var div;
	console.log(result);
	
		var rs = result;
		$.each(rs, function(key, rs) {

			table += '<tr>';
			table += '<td class="tullisFormalText">' + rs.testMethodId + '</td>';
			table += '<td class="tullisFormalText">' + rs.documentNumber + '</td>';
			table += '<td class="tullisFormalText">' + rs.documentTitle + '</td>';
			table += '<td class="tullisFormalText">' + rs.unit + '</td>';		
			table += '</tr>';
		});

	 
	var lineSpace = "<br />"
	var title =  "<h1>Test Methods</h1>"
	var headers = "<tr><td class='tullisFormalText'><strong>Test Method ID</strong></td><td class='tullisFormalText'><strong>Document Number</strong></td><td class='tullisFormalText'><strong>Document Title</strong></td><td class='tullisFormalText'><strong>Unit</strong></td></tr>";
	$(div).html('<table width="100%">' + lineSpace + title + lineSpace + headers + table + '</table>');
}
