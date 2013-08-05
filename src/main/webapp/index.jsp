<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html ><head>
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
$(function(){
	<%-- initialise the entire page layout (defined in layout_common.js) --%>
	initLayout("60%", "40%", "70%");

	<%-- initialise the navigation menu (accordion) --%>
	$("#accordion").accordion({ active: false });
	
});

</script>
</head>

<body>

<jsp:include page="${HEADER}"/>
<jsp:include page="${FOOTER}"/>

<div id="centerarea" class="outer-center">
	<div class="ui-layout-center">
		<div class="inner-center inner-single">
			<div class="inner_content_basictb">
				<h2>App Service Overview</h2>
					<div id="welcome_service">
						<ul class="static_info">
							<li>App Service uptime: <b><i></b></i></li>
						</ul>
					</div>
			</div>
		</div>
	</div>

<jsp:include page="${NAV}"/>

</div>
</body>
</html>
