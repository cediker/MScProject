$(document).ready(function() {

 
}); 
  $(document).ready(function(){  
	  
  });	 
  
  
  function buildpstd(result){
	  console.log(result);
	  
      var i=1;  
      	  
    	  i++;
    	  let options = '';
    	  let test ='';
    	
    	  result.forEach(function(row){
    		  testValue = "<p id=tullisFormalText value='"+ row.testMethod +"'>" + row.testMethod + "</p>";
    		  test = "<p name='row["+i+"][test]'>" +testValue+ "</p>";
    		  
    		  minValue = "<p id=tullisFormalText value='"+ row.minimum +"'>" + row.minimum + "</p>";
    		  min = "<p name='row["+i+"][test]'>" +minValue+ "</p>";
    		  
    		  maxValue = "<p id=tullisFormalText value='"+ row.maximum +"'>" + row.maximum + "</p>";
    		  max = "<p name='row["+i+"][test]'>" +maxValue+ "</p>";
    		  
    		   $('#dynamic_field').append('<tr id="row'+i+'">\
    				   <td id=tullisFormalText>'+test+'</td>\
    				   <td id=tullisFormalText>'+min+'</td>\
    				   <td id=tullisFormalText>'+max+'</td>\
    				   <td id=tullisFormalText><input type="text" placeholder="result"/></td>\
    				   </tr>'); 
		  });
    		
    	    
           
		 
      
  }
	  


//view production standard
$(function() {
	$("#btn-test-prodstd").click(function() {
		var prodStd = $('#prod-std').serialize();
		viewProdStd(prodStd);
		
	});
});



function viewProdStd(prodStd) {
	$.ajax({
				url : "viewProductionStandard",
				data : prodStd,
				success : function(result){
				var div = "#demo";
				buildpstd(result);
				}
	});
}


  
  
  





/*
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
}*/
  
