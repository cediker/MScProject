$(document).ready(function() {
});


$(function() {
	$('#btn-all-jobs').click(function() {
		getAllTestResults();
	});
});


//view production standard
$(function() {
	$("#btn-test-prodstd").click(function() {
		var prodStd = $('#prod-std').serialize();
		viewProdStd(prodStd);
		
	});
});



$(function() {
	$('#btn-by-jobNumber').click(function() {
		getTestResultByJobNumber();
	});
});


function viewProdStd(prodStd) {
	$.ajax({
				url : "viewProductionStandard",
				data : prodStd,
				success : function(result){
				var div = "#demo";
				constructTable(result, div);
				}
	});
}


function getAllTestResults() {
	
	$.ajax({
				url : "getAllTestResults",
				success : function(result) {
				var div = "#demo";
				constructTable(result, div);
				}
	});
	}

function getTestResultByJobNumber() {
	
	$.ajax({
				url : "getTestResultByJobNumber",
				data : $("#formBasic1").serialize(),
				success : function(result){
				var div = "#demo";
				constructTable(result, div);
				}
	});
	
}


function constructTable(result, div){
	var table = '';
	var div;
	console.log(result);
	
		var rs = result;
		$.each(rs, function(key, rs) {

			table += '<tr>';
			table += '<td>' + rs.testMethod + '</td>';
			table += '<td>' + rs.minimum + '</td>';
			table += '<td>' + rs.maximum + '</td>';
			table += '<td class=editable></td>';
			
			
			table += '</tr>';
		});

	 
	var lineSpace = "<br />"
	var title =  "<h1>Production Testing</h1>"
	var headers = "<tr><td>Test Method</td><td>Minimum</td><td>Maximum</td></tr>";
	$(div).html('<table width="100%">' + lineSpace + title + lineSpace + headers + table + '</table>');
}
