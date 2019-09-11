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
					console.log(options);
				});

				dropdown = "<select id='dropdown'>" + options + "</select>";

				$('.productionStandardS').append('<td>' + dropdown + '</td>');
			}
		});


//method: getAllProductionStandards
function getproductionS(callback) {

	$.ajax({
		url : "getAllProductionStandards",
		success : function(result) {
			return callback(result)
		}
	});

}