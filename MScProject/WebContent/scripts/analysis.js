
$(document).ready(function() {
	//sets data array
	let data = [
		{label:'method 1', value:34},
		{label:'method 2', value:46},
		{label:'method 3', value:88},
		{label:'method 4', value:45},
	];
	//calls the loadData method
	loadChart(data);
	
	
	
	
 data = [
		{label:'method 1', value:34},
		{label:'method 2', value:33},
		{label:'method 3', value:22},
		{label:'method 4', value:45},
	];
 //sets timer
	setTimeout(function(){
		
	
	
		loadChart(data);
	}, 2000);
});


//array column function
function arrayColumn(array, columnName) {
    return array.map(function(value, value1, value2, index) {
        return value[columnName];
    })
}

//load chart function
function loadChart(rows, tm){
	
	//variables declared
	let labels = arrayColumn(rows, 'label');
	let data = arrayColumn(rows, 'value');
	let upperLimitData = arrayColumn(rows, 'value1');
	let lowerLimitData = arrayColumn(rows, 'value2');
	var ctx = document.getElementById('myChart');
	var myChart = new Chart(ctx, {
	    //defines the type of chart
		type: 'line',
	    //defines the data elements
	    data: {
	        labels: labels,
	        datasets: [{
	            label: tm,
	            tension: 0,
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
	            {label: 'Upper Limit '+tm,
	            data: upperLimitData,
	            backgroundColor: [
	                'rgba(161, 161, 161, 0.2)',
	           
	            ],
	            borderColor: [
	                'rgba(161, 161, 161, 1)',
	        
	            ],
	            fill:[
	            	false],
	            	borderWidth: 2,
	            	borderDash: [10,5]
	            
	            }, 
	            {label: 'Lower Limit '+tm,
	            data: lowerLimitData,
	            backgroundColor: [
	                'rgba(15, 99, 132, 0.2)'
	            ],
	            borderColor: [
	                'rgba(15, 99, 132, 1)'
	            ],
	            fill:[
	            	false],
	            borderWidth: 2,
	            borderDash: [10,5]
	            
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
	    	//gets dropdown value
			var ps = $('#dropdown').val();
			//calls viewTestMethodsInProdStd method
			viewTestMethodsInProdStd(ps);
			//notifys the user of success
			$.notify("It worked", "success");		
	    }    
	   });
	//runs code on change
	$(document).on('change','#dropdown',function(){
		let value = $(this).val();
		viewTestMethodsInProdStd(value);
	})
});

//viewTestMethodsInProdStd method
function viewTestMethodsInProdStd(ps) {
	$.ajax({
				url : "analysisTestMethodSelect",
				data : {productionStandard:ps},
				success : function(result){
					//declares testMethodData variable
					let TestMethodData = [];

					//sets TestMethodData to the value of result
					TestMethodData = result;
					//calls build method
					build(TestMethodData);
						
					//build test method
					function build(TestMethodData) {
						//declares variables
						let options1 = '';
						let dropdown1 = '';
						//loops through test method data
						TestMethodData.forEach(function(row) {
							//adds dropdown elements
							options1 += "<option value='" + row.testMethod
									+ "'>" + row.testMethod + "</option>";
							
						});
						//applies drop down elements to select
						dropdown1 = "<select id='dropdown1'>" + options1 + "</select>";

						$('.testMethodDropdown').append('<td>' + dropdown1 + '</td>');
					}
					
				}

	});
}



//get drop down parameters 
$(function() {
	$("#btn-getTestMethods-byPrdStd").click(function() {
		//declares variables and sets them to the value of the drop down boxes
		var ps = $('#dropdown').val();
		var tm = $('#dropdown1').val();
		//calls getLimits method
		getLimits(ps, tm);
	});
	
});

//getGraphParameters method
function getGraphParameters(ps, tm, upperLimit, lowerLimit) {
	$.ajax({
				url : "graphParameters",
				data : {productionStandard:ps, testMethod:tm},
				success : function(result){
					//declares variables
					let testResult;
					let xAxis;
					let data = [];
					let upperLimitData = [];
					let lowerLimitData = [];
					//loops through results
					$.each(result, function(key, result) { 
						//assigns x-axis information
						xAxis = result.jobNumber + " " + result.roll;
						//assigns data to object and pushes it into the data array
						data.push({label:xAxis, value:result.testResult, value1:upperLimit, value2:lowerLimit});
						
					})
					//loads chart
					loadChart(data, tm);
				}

	});
}

//getLimits function
function getLimits(ps, tm) {
	$.ajax({
		url : "viewProductionStandardLimitsServlet",
		data : {productionStandard:ps, testMethod: tm},
		success : function(result){
			//declares variables
			let upperLimit;
			let lowerLimit;
			//loops through results
			$.each(result, function(key, result) { 
				//assigns tolerance values to variables
				upperLimit = result.maximum;
				lowerLimit = result.minimum;
			})
			//calls getGraphParameters
			getGraphParameters(ps, tm, upperLimit, lowerLimit);
		}

});
}





