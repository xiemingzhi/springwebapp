<%@ include file="/jsp/common/taglibs.jsp"%>
<div style="position:absolute; margin:0px; left:0px; right:auto; top:29px; bottom:0px; height:544px; z-index:0; display:block; visibility:visible; width:178px;" class="ui-layout-west container border ui-layout-pane ui-layout-pane-west">
	<div id="accordion">
		<h3><a href="#">Contacts App</a></h3>
			<div>
				<ul>
					<li><a href="#">Settings (TBA)</a></li>
					<c:url var="contactsListUrl" value="/listcontacts.htm"/>
				    <li><a href="${contactsListUrl }">Contacts Name</a></li>
				</ul>
			</div>
		<h3><a href="#">Next App</a></h3>
			<div>
				<ul>
					<li><a href="#">Current App Usage</a></li>
					<li><a href="#">This App Settings (TBA)</a></li> 
				</ul>
			</div>
	</div>
</div>

<script type="text/javascript">
<%-- e.g. initNaviPane('#accordion', 1, 'Contacts Name'); --%>
function initNaviPane(accordion_selector, iExpand_level, highlight_menuitem)
{
	<%-- initialise navigation accordion --%>
	$(accordion_selector).accordion({active: iExpand_level, header: "h3" });
	var menuitems = $(accordion_selector + " li");

	<%-- on-click and highlight effects --%>
	menuitems.click(function(){
		$(accordion_selector + " li.nav_bg").stop(true, true).show().removeClass('nav_bg');
		$(this).stop(true, true).show().addClass('nav_bg');
		var t = 50;
		<%-- $(this).fadeOut(t).fadeIn(t).fadeOut(t).fadeIn(t).fadeOut(t).fadeIn(t); --%>
	}).focus(function(){
		<%-- for IE7/8 --%>
		$(this).blur();
	});

	
	<%-- highlight the menuitem --%>
	menuitems.filter(function(index){
		//alert($(this).find('a').text().toLowerCase());
		//alert(highlight_menuitem.toLowerCase());
		//if ($(this).find('a').text().toLowerCase() == highlight_menuitem.toLowerCase()) alert('yes');
		if ($(this).find('a').text().toLowerCase() == highlight_menuitem.toLowerCase()) return true;
		return false;
	}).trigger('click');
}
</script>
