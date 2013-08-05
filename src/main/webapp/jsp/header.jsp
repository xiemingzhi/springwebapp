<%@include file="/jsp/common/taglibs.jsp"%>
<style>
.ui-widget-content .ui-state-default
{
	border: 1px solid #C6C6C6;
	box-shadow: 2px 2px 2px #cccccc;
}

#cpfailed
{
	color:red;
	font:italic sans-serif;
	text-align:center;
	padding:0;
	margin:0;
}

</style>
<script type="text/javascript" src="${JQ_BGI}"></script>
<script type="text/javascript" src="${DLG_FIX_JS}"></script>
<script type="text/javascript">

function confirmAndJump(btnstyle, ttl, desturl, mainmsg, submsg, oDialogOptions)
{
	var btn;
	switch (btnstyle)
	{
		case 'ok':
			btn = {
				OK: function(){
					$(this).dialog('close');
					if (null != desturl) $('#jump-to').attr('action', desturl).submit();
				}
			};
			break;

		case 'yn':
			btn = {
				Yes: function() {
					$(this).dialog('close');
					$('#jump-to').attr('action', desturl).submit();
				},
				No: function() {
					$(this).dialog('close');
				}
			};
			break;

		case null:
			break;

		default:
			return;
	}

	$('#mainmsg').html(mainmsg);
	$('#submsg').html(submsg);

	if (oDialogOptions === undefined) oDialogOptions = {buttons: btn};
	else if (oDialogOptions.buttons === undefined) oDialogOptions.buttons = btn;

	$('#commonDlg').dialog('option', oDialogOptions).dialog('open');
	$('#ui-dialog-title-commonDlg').html(ttl);
}

function alertOnly(ttl, mainmsg, submsg, oDialogOptions)
{
	confirmAndJump('ok', ttl, null, mainmsg, submsg, oDialogOptions);
	dialogGetButton($('#commonDlg'), 0).focus();
}

function mustRelogin()
{
	confirmAndJump(
		'ok',
		"Session Expired",
		"index.jsp",
		"Sorry, your current session has expired.",
		"Press \"OK\" to return to the Sign In page."
	);
	dialogGetButton($('#commonDlg'), 0).focus();
}

function showOSD(htmltext, cbfn)
{
	$('iframe').show();
	$('#ovl').show();

	var ot = $('#osdtext');
	if (htmltext instanceof jQuery) ot.append(htmltext);
	else ot.html(htmltext);

	var osd = $('#osd');
	osd.show();
	var ow = osd.outerWidth(), oh = osd.outerHeight();
	var x = ($(window).width() - ow) >> 1, y = ($(window).height() - (oh << 1)) >> 1;
	osd.offset({left:x, top:y}).fadeIn(1000, cbfn);
}

function dismissOSD()
{
	$('#osd').hide(); $('#ovl').hide(); $('iframe').hide()
}

<%-- **************** ON DOCUMENT READY **************** --%>
$(function(){
	$('#commonDlg').dialog({
		autoOpen: false,
		modal: true,
		position: 'center',
		width: ~~($(window).width() / 355 * 113),
		height: 'auto',
		zIndex: 10005,
		show: {effect:'drop', direction:'down', duration:200, distance:150},
		hide: {effect:'drop', direction:'down', duration:200, distance:150},
		open: function(_ev, _ui){
			dialogCommonFix($(this));
		},
		closeOnEscape: false,
		resizable: false
	});

	$('#toolbar_logout').click(function(){
		confirmAndJump(
			'yn',
			"Confirm Logout",
			"index.jsp",
			"Do you really want to logout ?",
			"Press 'Yes' to proceed, 'No' to cancel."
		);
	});

	$('#logo').click(function(){
		<c:url var="portalUrl" value="index.jsp"/>
		$('#jump-to').attr('action', "${portalUrl}").submit();
	});

	<%-- clear out the error msgs if any --%>
	$("input").focus(function(){
		$('#cpfailed').text("");
	});

	<%-- adjust common dialogue width whenever browser window size changes --%>
	$(window).resize(function(){
		dialogAutoCenter($('#commonDlg'));
	});
	<%--  unbind hover event handler for IE6 --%>
	$(".ui-layout-pane").unbind('hover');
	$(".ui-layout-resizer").unbind('hover');
	
});
</script>
<div style="position:absolute; margin:0px; top:0px; bottom:auto; left:0px; right:0px; width:auto; z-index:0; display:block; visibility:visible; height:80px;" class="outer-north container ui-layout-pane ui-layout-pane-north">
<div id="banner" class="block lite">
	<div id="headerwrap">
		<div id="header">
			<div id="logo"></div>
				<h1 align="left">Web Portal</h1>
				<ul id="toolbar">
					<li id="toolbar_logout"><span>Logout</span></li>
					<li id="toolbar_user">Hi, User</li>
				</ul>
		</div>
		<div id="header_shadow"></div>
	</div>
</div>
<div id="commonDlg" style="display:none">
	<p>
		<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 50px 0;"></span>
		<div id="mainmsg" style="text-align:left;font-weight:bold;font-size:140%"></div>
	</p>
	<p id="submsg" style="text-align:left;padding-left:2em;"></p>
</div>
<form id="jump-to" method="post" style="display:none"></form>
</div>

<iframe marginheight="0" marginwidth="0" width="0" height="0" scrolling="no" frameborder="0" src="javascript:'';"></iframe>
<div id=ovl>&nbsp;</div>
<div id=osd>
	<div id=osdtext></div>
</div>
