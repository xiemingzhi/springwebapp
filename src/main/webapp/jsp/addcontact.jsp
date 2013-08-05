<%@include file="/jsp/common/taglibs.jsp"%>
<%@ include file="/jsp/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
<title>Web Portal</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="${JQ_UI_CSS}" />
<link type="text/css" rel="stylesheet" href="${JQ_LAYOUT_CSS}"/>
<link type="text/css" rel="stylesheet" href="${TOP_CSS}/dt_page.css"/>
<link type="text/css" rel="stylesheet" href="${TOP_CSS}/dt_jui.css"/>
<link type="text/css" rel="stylesheet" href="${TOP_CSS}/dt_tools.css"/>
<link type="text/css" rel="stylesheet" href="${TOP_CSS}/accordion.css"/>
<link type="text/css" rel="stylesheet" href="${TOP_CSS}/layout-resizer.css"/>
<link type="text/css" rel="stylesheet" href="${TOP_CSS}/common.css"/>
<style type="text/css">

</style>
<script type="text/javascript" src="${JQ}"></script>
<script type="text/javascript" src="${JQ_UI}"></script>
<script type="text/javascript" src="${JQ_LAYOUT}"></script>
<script type="text/javascript" src="${JQ_DT}"></script>
<script type="text/javascript" src="${LAYOUT_JS}"></script>
<script type="text/javascript" src="${DT_CUSTOM_JS}"></script>
<script type="text/javascript">

<%-- **************** ON DOCUMENT READY **************** --%>
$(function(){
	initLayout("85%","50%","99%");
	initNaviPane('#accordion', 0, 'Contacts Name');

});

function goList() {
	<c:url var="contactsListUrl" value="listcontacts.htm"/>
	$('#jump-to').attr('action', "${contactsListUrl}").submit();
}

</script>
</head>

<body class="ui-layout-container" onload="set_active_cube('cube_create')">
<jsp:include page="${HEADER}"/>
<jsp:include page="${FOOTER}"/>

<div id="centerarea" class="outer-center">
	<div class="ui-layout-center">

<%@include file="listcontacts_cubes.jsp"%>

		<div class="inner-south" id="south_content">
			<div class="inner_content_basictb">
<%--============ ADD YOUR SPECIFIC PAGE CONTENTS BELOW THIS LINE ============--%>
<h2>Insert Contact Form</h2>
<form:form modelAttribute="contact" action="addcontact.htm" method="post">
	<TABLE class="contacts_tb_required">
		<TBODY>
			<!-- TR>
				<TH>Contact Id</TH>
				<TD><form:input path="contactId" /></TD>
			</TR-->
			<TR>
				<TD class="contacts_left_td_required">First Name</TD>
				<TD class="contacts_right_td"><form:input type="text" size="35" style="border:1px solid #C0C0C0;text-align:left;margin:.3em 0 0 .3em;" maxlength="64" path="firstName" /><form:errors path="firstName" /></TD>
			</TR>
			<TR>
				<TD class="contacts_left_td_required">Last Name</TD>
				<TD class="contacts_right_td"><form:input type="text" size="35" style="border:1px solid #C0C0C0;text-align:left;margin:.3em 0 0 .3em;" maxlength="64" path="lastName" /></TD>
			</TR>
			<TR>
				<TD class="contacts_left_td_required">Email</TD>
				<TD class="contacts_right_td"><form:input type="text" size="35" style="border:1px solid #C0C0C0;text-align:left;margin:.3em 0 0 .3em;" maxlength="64" path="email" /><form:errors path="email" /></TD>
			</TR>
			<TR>
				<TD colspan="2" class="contacts_btn">
					<input id="submitbutton" type="submit" value="Saves" class="btn_blue75">
					<input type="button" value="Cancel" class="btn_grey75" onclick="goList()">
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</form:form>
<script>
$(document).ready(function() {
	// check name availability on focus lost
	
	$('#email').blur(function() {
		if ($('#email').val()!='') {
			//alert('you typed something inside email');
			checkVacancy();
		}
	});
	
});
/*
$('#email').blur(function() {
	if ($('#email').val()!='') {
		//alert('you typed something inside email');
		checkVacancy();
	}
});
*/
function checkVacancy() {
	//alert('inside checkVacancy');
	
	/* $.ajaxSetup({"error":function(XMLHttpRequest,textStatus, errorThrown) {   
      alert(textStatus);
	  alert(errorThrown);
  	  alert(XMLHttpRequest.responseText);
		}}); */
	
	$.getJSON("occupied.htm", { email: $('#email').val() }, function(isOccupied) {
		//alert('isOccupied is ' + isOccupied);
		//cannot have '.' inside id attribute!!!
		if (isOccupied) {
			$("#email").after("<span id='emailerrors'>email already occupied</span>");
			$("#submitbutton").attr("disabled", true);
		} else {
			$("#emailerrors").remove();
			$("#submitbutton").attr("disabled", false);
		}
		
	});
}

</script>
<%--============ ADD YOUR SPECIFIC PAGE CONTENTS ABOVE THIS LINE ============--%>
			</div>
		</div>
	</div>
<jsp:include page="${NAV}"/>
</div>
</body>
</html>
