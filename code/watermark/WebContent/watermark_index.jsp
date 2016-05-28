<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
</head>
<body  style="background: #e1e9eb;">


	<form name="form1" action="${pageContext.request.contextPath}/watermark.action"  method="post" enctype="multipart/form-data">
		<div class="right">
		
		<div class="current">当前位置：上传图片</div>
			
				<div class="rightCont">
				<p class="g_title fix">筛选条件</p>
				<table align="center" style="width: 80%"  class="tab1">
					<tr align="center">
						<td colspan="3"></td>
						<td align="right"><input type="submit" value="上传图片"  class="tabSub" ></td>
					</tr>
					<tr>
						<td align="right">类型选择：</td>
						<td align="left">
							<select name="watermark_type" style="width: 160px" class="allSelect">
								<option value="01">图片</option>
								<option value="02">文字</option>
							</select>
						</td>
						<td align="right">水印位置：</td>
						<td align="left">
							<select name="watermark_place" style="width: 160px" class="allSelect">
								<option value="01">居中</option>
								<option value="02">左上角</option>
								<option value="03">右上角</option>
								<option value="04">左下角</option>
								<option value="05">右下角</option>
								<option value="06">铺满</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">图片或文字旋转角度：</td>
						<td align="left">
							<input name="watermark_angle" style="width: 160px"  class="allInput"/>正负360(负数为逆时旋转)(仅适用于水印铺满)
						</td>
						
						<td align="right">水印透明度：</td>
						<td align="left">
							<input name="watermark_alpha" style="width: 160px"  class="allInput"/>小于等于10的数字
						</td>
					</tr>
					<tr>
						<td align="right">水印文字：</td>
						<td align="left">
							<input name="watermark_font" style="width: 160px" class="allInput"/>
						</td>
						<td align="right">水印文字大小：</td>
						<td align="left">
							<input name="watermark_font_size" style="width: 160px" class="allInput"/>
						</td>
					</tr>
					<tr>
						<td align="right">水印文字颜色：</td>
						<td align="left">
							<select name="watermark_font_color" style="width: 160px" class="allSelect">
								<option value="01">红</option>
								<option value="02">黄</option>
								<option value="03">蓝</option>
								<option value="04">绿</option>
								<option value="05">黑</option>
								<option value="06">白</option>
							</select>
						</td>
						<td align="right"></td>
						<td align="left">
						</td>
					</tr>
					<tr>
						<td>&nbsp</td>
						<td>&nbsp</td>
						<td>&nbsp</td>
						<td>&nbsp</td>
					</tr>
					
				</table>
<!-- 			</div> -->
<!-- 			<div class="rightCont"> -->
				<p class="g_title fix">图片列表</p>
				<table align="center" style="width: 80%"  class="tab1">
					<tr align="center">
						<td><input type="file" name="image" class="allFile" /></td>
						<td><input type="file" name="image" class="allFile" /></td>
						<td><input type="file" name="image" class="allFile" /></td>
						<td><input type="file" name="image" class="allFile" /></td>
					</tr>
					
				</table>
			</div>
		</div>
			
	</form>
</body>
</html>