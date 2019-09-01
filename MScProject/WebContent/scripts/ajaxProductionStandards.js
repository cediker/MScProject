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
	console.log(result);
	
		var rs = result;
		$.each(rs, function(key, rs) {

			table += '<tr>';
			table += '<td>' + rs.productionStandardName + '</td>';
			table += '<td>' + rs.testMethod + '</td>';
			table += '<td>' + rs.documentTitle + '</td>';
			table += '<td>' + rs.minimum + '</td>';		
			table += '</tr>';
		});

	 
	var lineSpace = "<br />"
	var title =  "<h1>Test Methods</h1>"
	var headers = "<tr><td><strong>Test Method ID</strong></td><td><strong>Document Number</strong></td><td><strong>Document Title</strong></td><td><strong>Unit</strong></td></tr>";
	$(div).html('<table width="100%">' + lineSpace + title + lineSpace + headers + table + '</table>');
}






  });
