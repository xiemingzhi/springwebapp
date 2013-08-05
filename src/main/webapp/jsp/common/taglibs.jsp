<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%
	response.setHeader("Cache-Control", "no-cache");	// HTTP 1.1
	response.setHeader("Pragma", "no-cache");			// HTTP 1.0
	response.setDateHeader("Expires", 0);				// for proxy server
%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>

<%-- The following constants point to jQuery JavaScript filenames which varies with their version upgrades --%>
<%-- All JSPs which utilises jQuery stuffs must reference them with these constants instead of referencing them
     directly with their original filenames (which contains version numbers that may change in the future). --%>
<c:set var="JQ"				value="js/jquery-1.8.3.js"/>
<c:set var="JQ_LAYOUT"		value="js/jquery.layout-1.3.0.min.js"/>
<c:set var="JQ_UI"			value="js/jquery-ui.js"/>
<c:set var="JQ_VALIDATE"	value="js/jquery.validate-1.10.0.min.js"/>
<c:set var="JQ_VALIDATE_AM"	value="js/jquery.validate-1.10.0.additional-methods.min.js"/>
<c:set var="JQ_DT"			value="js/jquery.dataTables-1.9.4.min.js"/>
<c:set var="JQ_DLB"			value="js/jquery.dualListBox-1.3.min.js"/>
<c:set var="JQ_BGI"			value="js/jquery.bgiframe.js"/>

<%-- CSS for jQuery libs --%>
<c:set var="JQ_UI_CSS"		value="css/jquery-ui-1.8.24.custom.css"/>
<c:set var="JQ_LAYOUT_CSS"	value="css/layout-default-1.3.0.css"/>
<c:set var="TOP_CSS"		value="css"/>

<c:set var="LAYOUT_JS"	value="js/layout_common.js"/>
<c:set var="DT_CUSTOM_JS"	value="js/dt_custom.js"/>
<c:set var="PLATFORM_JS"	value="js/platform.js"/>
<c:set var="DLG_FIX_JS"		value="js/dlgfix.js"/>

<c:set var="TOP_JSP"		value="/jsp"/>
<c:set var="HEADER"	value="${TOP_JSP}/header.jsp"/>
<c:set var="FOOTER"	value="${TOP_JSP}/footer.jsp"/>
<c:set var="NAV"	value="${TOP_JSP}/nav.jsp"/>
