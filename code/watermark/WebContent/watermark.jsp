<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理结果</title>
</head>
<body>

<table width="99%" align="center">

	<s:iterator value="picInfo">
	
		<tr>	
			<td width="50%" ><img src=${pageContext.request.contextPath }<s:property value="imageURL"/> width="95%" /></td>
			<td width="50%" ><img src=${pageContext.request.contextPath }<s:property value="logoImageURL"/> width="95%" /></td>
		</tr>
	</s:iterator>



</table>

</body>
</html>