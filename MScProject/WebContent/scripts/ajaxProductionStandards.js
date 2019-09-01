 $(document).ready(function() {

 
}); 
  $(document).ready(function(){  
      var i=1;  
      $('#add').click(function(){  
           i++;  
		   $('#dynamic_field').append('<tr id="row'+i+'">\
		   <td><input type="text" id="autocomplete" name="row['+i+'][test]" placeholder="Test" class="form-control name_list" /></td>\
		   <td><input type="text" name="row['+i+'][min]" placeholder="Min" class="form-control name_list" /></td>\
		   <td><input type="text" name="row['+i+'][max]" placeholder="Max" class="form-control name_list" /></td>\
		   <td colspan="2"><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td>\
		   </tr>');  
      });  
      $(document).on('click', '.btn_remove', function(){  
           var button_id = $(this).attr("id");   
           $('#row'+button_id+'').remove();  
	  }); 


//add test method
$(function() {
	$("#btn-submit").click(function() {
		var testMethod = $('#addProductionStandard').serialize();
		addProductionStandard(testMethod);
		
	});
});



//add test method
$(function() {
	$("#btn-getPrdstd-byPrdStd").click(function() {
		var prodStd = $('#view-prod-std').serialize();
		viewProdStd(prodStd);
		
	});
});





//method: addTestMethod
	function addProductionStandard(testMethod) {
		
	$.ajax({
		url: "productionStandardServlet",
		data: testMethod,
		dataType: "text",
		type: "POST",
		success: function(result) {
			console.log(testMethod);
			
		}
	});
}
	
	

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



function constructTable(result, div){
	var table = '';
	var div;
	var title;
	var date;
	console.log(result);
	
		var rs = result;
		var title;
		var description;
			
		
		$.each(rs, function(key, rs) { 
			
			title = null;
			title = rs.productionStandardName;
			date = null;
			date = rs.dateCreated;
			description = null;
			description = rs.description;
			table += '<tr>';
			table += '<td>' + rs.testMethod + '</td>';
			table += '<td>' + rs.description + '</td>';
			table += '<td>' + rs.minimum + '</td>';		
			table += '<td>' + rs.maximum + '</td>';
			table += '</tr>';
			
		});

	var title1 =  "<h4 class=leftAlign>Production Standard Code: "+ title +"</h4>"
	var description1 = "<h2>"+ description +"</h2>"
	var lineSpace = "<br />"
	var headers = "<tr><td><strong>Test Method</strong></td><td><strong>Description</strong></td><td><strong>Minimum Value</strong></td><td><strong>Maximum Value</strong></td></tr>";
	$(div).html('<table width="100%">' + lineSpace + title1 + '</br>' + description1 + lineSpace + headers + table + '</table>'+'<br>'+'<p>Date Created: </p>'+date);
	
}






  });
