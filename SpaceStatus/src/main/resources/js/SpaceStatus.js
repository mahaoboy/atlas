jQuery(function($){    
	var initfunc = function()
	{
		$("#button").click(function(){
   		$("#box").toggle();
   		alert("xxx");
		});
	};
	$(document).ready(function()
    {
        initfunc();
    });
});