
$(document).ready(function() {
	var ctx = document.getElementById('myChart');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: ['512111', '514333', '518444', '513222', '518111', '51865'],
	        datasets: [{
	            label: 'Grammage',
	            data: [79.8, 76.9, 80, 81.5, 80.9, 80],
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
	            data: [82, 82, 82, 82, 82, 82],
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
});



