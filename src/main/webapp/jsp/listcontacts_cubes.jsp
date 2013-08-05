<%@include file="/jsp/common/taglibs.jsp"%>
<div class="inner-center">
	<div class="ui-layout-content">
		<div id="top_area">
			<ul id="upper">
				<c:url var="contactsListUrl" value="listcontacts.htm"/>
				<li><div id="cube_list" class="imagelink list"><a href="${contactsListUrl }"><p class="upper_icon_font">Contacts List</p></a></div></li>
				<c:url var="contactsCreateUrl" value="addcontact.htm"/>
				<li><div id="cube_create" class="imagelink create"><a href="${contactsCreateUrl }"><p class="upper_icon_font">Create Contact</p></a></div></li>
			</ul>
		</div>
	</div>
</div>


<script type="text/javascript">
/* upper icons
-------------------------------------------------------------------------- */
$(function(){
// Append span to each LI to add reflection
	$("#upper li").append("<span></span>");
	// Animate buttons, move reflection and fade
	$(".imagelink").hover(function() {
		if ($(this).next().hasClass("active_cube_shadow")) return;
	    $(this).stop().animate({ marginTop: "-10px" }, 200);
	    $(this).next().stop().animate({ marginTop: "18px", opacity: 0.5 }, 200);
	},function(){
	    $(this).stop().animate({ marginTop: "0px" }, 300);
	    $(this).next().stop().animate({ marginTop: "1px", opacity: 1 }, 300);
	});
	$(".imagelink").click(function(){
		if ($(this).next().hasClass("active_cube_shadow")) return;
		$("span.active_cube_shadow").removeClass("active_cube_shadow").trigger('mouseleave');
		$(this).next().addClass("active_cube_shadow");
		
	<%-- for IE7/8 --%>
	$("#upper a").focus( function(){
	        $(this).blur();
		});
	});
});


</script>