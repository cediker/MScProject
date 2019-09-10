$(document).ready(
		function() {
			let productionSData = [];

			getproductionS(function(data) {
				productionSData = data;
				build(productionSData);

			});

			function build(productionSData) {

				let options = '';
				let dropdown = '';

				productionSData.forEach(function(row) {
					options += "<option value='" + row.productionStandardName
							+ "'>" + row.productionStandardName + "</option>";
				});

				dropdown = "<select id='dropdown'>" + options + "</select>";

				$('.productionStandardS').append('<td>' + dropdown + '</td>');
			}
		});

// view production standard
$(function() {
	$("#btn-test-prodstd").click(function() {
		var sel = document.getElementById('dropdown');
		var value = $('#dropdown').val();
		console.log(value);
		viewProdStd(value);

	});

	$(document).on('keyup', '.txt-result', function(){
		var value = $(this).val();
		var min = $(this).data('min');
		var max = $(this).data('max');
		console.log(value, min, max);
		
		if(min!="" && max!=""){
			if(min<=value && max>=value){
				$(this).css('background','green');		
			}
			if(min>value){
				$(this).css('background','red');	
			}
			if(max<value){
				$(this).css('background','red');
			}
			
		}
		
		
		
		if(min!="" && max==""){
			if(min<=value){
				$(this).css('background','green');	
			}
			if(min>value){
				$(this).css('background','red');	
			}
		}
		
		if(min=="" && max!=""){
			if(max<value){
				$(this).css('background','red');	
			}
			if(max>=value){
				$(this).css('background','green');	
			}
		}
		
		
	})
});

// method: getAllProductionStandards
function getproductionS(callback) {

	$.ajax({
		url : "getAllProductionStandards",
		success : function(result) {
			return callback(result)
		}
	});

}

function buildpstd(result) {
	console.log(result);

	var i = 1;

	i++;
	let testValue = '';
	let test = '';
	let minValue = '';
	let min = '';
	let maxValue = '';
	let max = '';

	result
			.forEach(function(row, count) {
				testValue = "<p>" + row.testMethod + "</p>";
				test = "<p>" + testValue + "</p>";

				minValue = "<p>" + row.minimum + "</p>";
				min = "<p>" + minValue + "</p>";

				maxValue = "<p>" + row.maximum + "</p>";
				max = "<p>" + maxValue + "</p>";

				$('#dynamic_field')
						.append('<tr id="row' + i + '">\
    				   <td id=tullisFormalText>'
										+ test
										+ '</td>\
    				   <td id=tullisFormalText>'
										+ min
										+ '</td>\
    				   <td id=tullisFormalText>'
										+ max
										+ '</td>\
    				   <td id=tullisFormalText>\
										<input type="hidden" name="items['+count+'][name]" value="'+row.testMethod+'"/>\
										<input type="number" class="txt-result" name="items['+count+'][value]" \
										data-min="'+row.minimum+'" data-max="'+row.maximum+'" placeholder="result"/></td>\
    				   </tr>');
			});
}																		

function viewProdStd(prodStd) {
	$.ajax({
		url : "viewProductionStandard",
		data : {productionStandard:prodStd},
		success : function(result) {
			var div = "#demo";
			buildpstd(result);
		}
	});
}

//view production standard
$(function() {
	$("#btn-submit").click(function() {
		var value = $('#dropdown').val();
		var jobNumber = $('#jobNumber').val();
		var roll = $('#roll').val()
		console.log(value, jobNumber, roll);
		var testResult = $('#addTestResult').serialize();
		console.log(testResult);
		addTestResult(value, jobNumber, roll, testResult);
	});

});

function addTestResult(value, jobNumber, roll, testResult) {
	$.ajax({
		url : "AddTestResult",
		type: "POST",
		data: {value, jobNumber, roll, testResult},
		dataType: "text",
		success : function(result) {
			console.log(data);
		}
	});
}




