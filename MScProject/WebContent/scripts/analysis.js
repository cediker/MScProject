
$(document).ready(function() {
	
	let data = [
		{label:'method 1', value:34},
		{label:'method 2', value:46},
		{label:'method 3', value:88},
		{label:'method 4', value:45},
	];
	
	loadChart(data);
	
	
	
	
 data = [
		{label:'method 1', value:34},
		{label:'method 2', value:33},
		{label:'method 3', value:22},
		{label:'method 4', value:45},
	];
	setTimeout(function(){
		
	
	
		loadChart(data);
	}, 2000);
});



function arrayColumn(array, columnName) {
    return array.map(function(value,index) {
        return value[columnName];
    })
}

function loadChart(rows){
	
	let labels = arrayColumn(rows, 'label');
	let data = arrayColumn(rows, 'value');
	
	var ctx = document.getElementById('myChart');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: labels,
	        datasets: [{
	            label: 'Grammage',
	            data: data,
	            backgroundColor: [
	                'rgba(32, 37, 252, 0.2)'
	            ],
	            borderColor: [
	                'rgba(32, 37, 252, 1)'
	        ] ,
	        fill:[
            	false],
            	borderWidth: 2
            	}, 
	            {label: 'Grammage Upper Limit',
	            data: data,
	            backgroundColor: [
	                'rgba(161, 161, 161, 0.2)',
	           
	            ],
	            borderColor: [
	                'rgba(161, 161, 161, 1)',
	        
	            ],
	            fill:[
	            	false],
	            	borderWidth: 2
	            
	            }, 
	            {label: 'Grammage Lower Limit',
	            data: [78, 78, 78, 78, 78, 78],
	            backgroundColor: [
	                'rgba(15, 99, 132, 0.2)'
	            ],
	            borderColor: [
	                'rgba(15, 99, 132, 1)'
	            ],
	            fill:[
	            	false],
	            borderWidth: 2
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: false
	                }
	            }]
	        }
	    }
	});
	
	
}


//find test methods from production standard
$(function() {
	$('#prod-std-find').validate({ 
	    submitHandler: function(form) {
			var ps = $('#dropdown').val();
			console.log(ps);
			viewTestMethodsInProdStd(ps);
			$.notify("It worked", "success");		
	    }    
	   });
	
	$(document).on('change','#dropdown',function(){
		let value = $(this).val();
		viewTestMethodsInProdStd(value);
		
	})
});


function viewTestMethodsInProdStd(ps) {
	$.ajax({
				url : "analysisTestMethodSelect",
				data : {productionStandard:ps},
				success : function(result){
				console.log(result);
					let TestMethodData = [];

					
					TestMethodData = result;
					console.log(TestMethodData);
					build(TestMethodData);
						
					
					function build(TestMethodData) {

						let options1 = '';
						let dropdown1 = '';
						
						TestMethodData.forEach(function(row) {
							
							options1 += "<option value='" + row.testMethod
									+ "'>" + row.testMethod + "</option>";
							console.log(options1);
						});

						dropdown1 = "<select id='dropdown1'>" + options1 + "</select>";

						$('.testMethodDropdown').append('<td>' + dropdown1 + '</td>');
					}
					
				}

	});
}


