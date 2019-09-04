$(document).ready(function() {

 
}); 
  $(document).ready(function(){  
	  
	  let testMethodData = [];
	  getTestMethods(function(data){
		  testMethodData = data;
		  
	  });
	    
	  
      var i=1;  
      $('#add').click(function(){  
    	  
    	  i++;
    	  
    	  let options = '';
    	  testMethodData.forEach(function(row){
    		  options += "<option value='"+ row.documentTitle +"'>" + row.documentTitle + "</option>";
		  });
    	  
    	  let dropdown = "<select name='row["+i+"][test]'>" +options+ "</select>";
    	  
            
           
		   $('#dynamic_field').append('<tr id="row'+i+'">\
		   <td>'+dropdown+'</td>\
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



//view production standard
$(function() {
	$("#btn-getPrdstd-byPrdStd").click(function() {
		$("#imageDyn").show();
		$("#btnPrint").show();
		var prodStd = $('#view-prod-std').serialize();
		viewProdStd(prodStd);
		
	});
});


//delete production standard
$(function() {
	$("#btn-deletePrdstd-byPrdStd").click(function() {
		var prodStd = $('#delete-prod-std').serialize();
		deleteProdStd(prodStd);
		
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
	
	//method: getAllTestMethods
function getTestMethods(callback) {
		
		$.ajax({
					url : "getAllTestMethods",
					success:function(result){
						return callback(result)
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


//method: getAllTestMethods
function getTestMethods(callback) {
		
		$.ajax({
					url : "getAllTestMethods",
					success:function(result){
						return callback(result)
					}
		});
				
		}


function deleteProdStd(prodStd) {
	$.ajax({
				url : "deleteProductionStandard",
				data : prodStd,
				success : function(result){
				var div = "#demo";
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






var cache_width = $('#a4print').width(); 
var a4 = [595.28, 841.89];


$(document).on("click", '#btnPrint', function () {
   
    $("#a4print").width((a4[0] * 1.33333) - 80).css('max-width', 'none');

}); 



  });
  
  
  
  
  
  

