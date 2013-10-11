jQuery(function ($) {
$(document).ready(function()
    {
    	$("ul.topul").hide();
        $('span.plusul').click(function(){
        	$(this).next().toggle(400);
        });
    });
});