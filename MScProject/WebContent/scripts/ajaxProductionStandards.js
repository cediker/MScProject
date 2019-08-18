 $(document).ready(function() {

 
}); 
  $(document).ready(function(){  
      var i=1;  
      $('#add').click(function(){  
           i++;  
		   $('#dynamic_field').append('<tr id="row'+i+'">\
		   <td><input type="text" id="autocomplete" name="row['+i+'][test]" placeholder="Test" class="form-control name_list" /></td>\
		   <td><input type="text" name="row['+i+'][min]" placeholder="Min" class="form-control name_list" /></td>\
		   <td><input type="text" name="row['+i+'][target]" placeholder="Target" class="form-control name_list" /></td>\
		   <td><input type="text" name="row['+i+'][max]" placeholder="Max" class="form-control name_list" /></td>\
		   <td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td>\
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






//method: addTestMethod
	function addProductionStandard(testMethod) {
	$.ajax({
		url: "productionStandardServlet",
		data: testMethod,
		type: "post",
		success: function(result) {
			$('#demo').text(result);
		}
	});
}
 });