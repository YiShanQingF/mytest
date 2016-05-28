package com.watermark.service;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import com.watermark.bean.WaterMark;

public interface MarkService {
	
	public static final String MARK_TEXT="慕课网";
	public static final String FONT_NAME="微软雅黑";
	/**文字样式-黑体*/
	public static final int FONT_STYLE = Font.BOLD;
	/**文字大小-120px  高度   宽度*/
	public static final int FONT_SIZE = 120 ;
	/**文字颜色-红色*/
	public static final Color FONT_COLOR = Color.red;
	
	/**水印位置*/
	public static final int X = 10;
	public static final int Y = 10;
	
	/**水印透明度   0-1 */
	public static float ALPHA = 0.3F;
	
	
	public static final String LOGO = "logo.png";
	
	
	public String watermark(File image, String imageFileName,String uploadPath, String realUploadPath, WaterMark waterMark);

}
