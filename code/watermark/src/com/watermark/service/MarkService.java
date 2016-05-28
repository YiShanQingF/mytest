package com.watermark.service;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import com.watermark.bean.WaterMark;

public interface MarkService {
	
	public static final String MARK_TEXT="Ľ����";
	public static final String FONT_NAME="΢���ź�";
	/**������ʽ-����*/
	public static final int FONT_STYLE = Font.BOLD;
	/**���ִ�С-120px  �߶�   ���*/
	public static final int FONT_SIZE = 120 ;
	/**������ɫ-��ɫ*/
	public static final Color FONT_COLOR = Color.red;
	
	/**ˮӡλ��*/
	public static final int X = 10;
	public static final int Y = 10;
	
	/**ˮӡ͸����   0-1 */
	public static float ALPHA = 0.3F;
	
	
	public static final String LOGO = "logo.png";
	
	
	public String watermark(File image, String imageFileName,String uploadPath, String realUploadPath, WaterMark waterMark);

}
