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
			console.log("Im here");
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
			table += '<td>' + rs.testMethodId + '</td>';
			table += '<td>' + rs.documentNumber + '</td>';
			table += '<td>' + rs.documentTitle + '</td>';
			table += '<td>' + rs.unit + '</td>';		
			table += '</tr>';
		});

	 
	var lineSpace = "<br />"
	var title =  "<h1>Job Information</h1>"
	var headers = "<tr><td>Test Method ID</td><td>Document Number</td><td>Document Title</td><td>Unit</td></tr>";
	$(div).html('<table width="100%">' + lineSpace + title + lineSpace + headers + table + '</table>');
}
