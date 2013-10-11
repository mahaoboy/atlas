jQuery(function ($) {
$(document).ready(function()
    {
    	$("ul.topul").hide();
        $('span.plusul>a').click(function(){
        	$("ul.topul").toggle(600);
        });
    });
});