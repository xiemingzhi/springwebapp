<%@include file="/jsp/common/taglibs.jsp"%>
<c:url var="dtAjaxSrcUrl" value="/contactapp/contacts/list.htm"/>

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
	initLayout("80%","1%","99%");
	<%-- contacts app is 0 --%>
	initNaviPane('#accordion', 0, 'Contacts Name');
	
	<%-- initialise DataTables --%>
	
	$('#contactserver_list').dataTable({
		"bProcessing": true,
		"sAjaxSource": '${dtAjaxSrcUrl}',
		"sPaginationType": "full_numbers",
		"sDom": '<"H"lrf>t<"F"ip>',
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"aLengthMenu": [5, 10, 25, 50, 100],
		"aoColumns":[
			{ mDataProp : 'contactId', "sWidth": "20%" },//contactid
			{ mDataProp : 'firstName', "sWidth": "15%" },//firstname
			{ mDataProp : 'lastName', "sWidth": "15%" },//lastname
			{ mDataProp : 'email', "sWidth": "15%", "sClass": "tb_left" }//email no comma for last one
		],
		"oLanguage": {
			"sProcessing": "Processing...",
			"sLoadingRecords": "Loading data...",
			"sSearch": "Search: _INPUT_<span id=clearDtSearchInput onclick='clearDtSearchInput()'>&nbsp</span>"
		}
	});
	
});
</script>
</head>

<body class="ui-layout-container" onload="set_active_cube('cube_list')">

<jsp:include page="${HEADER}"/>
<jsp:include page="${FOOTER}"/>

<div id="centerarea" class="outer-center">
	<div class="ui-layout-center">

<%@include file="listcontacts_cubes.jsp"%>

		<div class="inner-south" id="south_content">
			<div class="inner_content">
<%--============ ADD YOUR SPECIFIC PAGE CONTENTS BELOW THIS LINE ============--%>
				<h2>Contact List</h2>
					<div class="dt_container" style="width:1100px">
						<span class="searchable_mark"><font class="searchablestar_mark">*</font> Searchable column</span>
						<table cellpadding="0" cellspacing="0" border="0" class="display" id="contactserver_list" style="width:100%">
							<thead>
								<tr>
									<th><font class="searchablestar_mark">*</font> Contact ID</th>
									<th><font class="searchablestar_mark">*</font> First Name</th>
									<th><font class="searchablestar_mark">*</font> Last Name</th>
									<th><font class="searchablestar_mark">*</font> Email</th>
								</tr>
							</thead>
						</table>
					</div>

<%--============ ADD YOUR SPECIFIC PAGE CONTENTS ABOVE THIS LINE ============--%>
			</div>
		</div>
	</div>
<jsp:include page="${NAV}"/>
</div>
</body>
</html>
