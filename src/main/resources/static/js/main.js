$(document).ready(function() {
	
	////var token = $("meta[name='_csrf']").attr("content");
    //var header = $("meta[name='_csrf_header']").attr("content");
    
	var ip=location.host;
	$("#button").click(function() {
		$("#info1").hide();
		if($("#urlinput").val()==null || $("#urlinput").val()==""){
			$("#info1").text("Please enter url");
			$("#info1").show();
			return;
		}
		$.ajax({   
			type : 'POST',
			url : 'https://'+ ip +'/shortenurl',
			data : JSON.stringify({
				"fullUrl" : $("#urlinput").val()
			}),
			contentType : "application/json; charset=utf-8",
			/*beforeSend : function(xhr){
				xhr.setRequestHeader(header, token);
			},*/
			success : function(data) {
				$("#shorturltext").val(data.shortUrl);
			}
		});
	});
	$("#customButton").click(function() {
		$("#info").hide();
		if($("#cshorturltext").val()==null || $("#cshorturltext").val()==""|| $("#curlinput").val()==null || $("#curlinput").val()==""){
			$("#info").text("Please enter both input");
			$("#info").show();
			return;
		}
		var letters = /^[0-9a-zA-Z]+$/;
		if(!$("#cshorturltext").val().match(letters)){
			$("#info").text("Only alphabets and numeric character accepted");
			$("#cshorturltext").focus();
			$("#info").show();
			return;
		}
		$.ajax({
			type : 'POST',
			url : 'https://'+ ip +'/customUrl',
			data : JSON.stringify({
				"shortUrl" : $("#cshorturltext").val(),
				"fullUrl" : $("#curlinput").val()
			}),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				$("#cshorturltext").val(data.shortUrl);
				if(data.shortUrl==""){
					$("#info").text("Url already exists");
				}
				else{
					$("#info").text("Custom url generated");
				}
				$("#info").show();
			}
		});
	});
});