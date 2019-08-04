$(document).ready(function() {
});


$(function() {
	$('#btn-all-jobs').click(function() {
		getAllTestResults();
	});
});

$(function() {
	$('#btn-by-jobNumber').click(function() {
		getTestResultByJobNumber();
	});
});


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
			table += '<td>' + rs.id + '</td>';
			table += '<td>' + rs.jobNumber + '</td>';
			table += '<td>' + rs.roll + '</td>';
			table += '<td>' + rs.productionStandard + '</td>';
			table += '<td>' + rs.grammageBasePaper + '</td>';
			//table += '<td>' + rs.grammageRelease + '</td>';
			//table += '<td>' + rs.coatWeightAdhesive + '</td>';
			table += '<td>' + rs.coatWeightCoating + '</td>';
			
			table += '</tr>';
		});

	 
	var lineSpace = "<br />"
	var title =  "<h1>Job Information</h1>"
	var headers = "<tr><td>ID</td><td>JOB NUMBER</td><td>ROLL</td><td>PRODUCTION STANDARD</td><td>GRAMMAGE BASE PAPER</td><td>COAT WEIGHT COATING</td></tr>";
	$(div).html('<table width="100%">' + lineSpace + title + lineSpace + headers + table + '</table>');
}
