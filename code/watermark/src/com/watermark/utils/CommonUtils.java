package com.watermark.utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.watermark.common.WaterMarkConstant;

public class CommonUtils {

	/**
	 * ��ȡˮӡλ��
	 * @param watermark_place
	 * @param water_pic
	 * @param water_logo
	 * @return
	 */
	public static Map<String, Integer> getWater_place(String watermark_place, Map<String, Integer> water_pic,
			Map<String, Integer> water_logo) {
		int width = water_pic.get("width");
		int height = water_pic.get("height");
		int width1 = water_logo.get("width1");
		int heigth1 = water_logo.get("height1");
		int widthDiff = width - width1;
		int heigthDiff = height - heigth1;
		//ˮӡλ��
		int x = WaterMarkConstant.X;
		int y = WaterMarkConstant.Y;
		if(null==watermark_place || "".equals(watermark_place)){
			//��֤ˮӡ��ͼƬ�����½�
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//01����
		else if(watermark_place.equals("01")){
			x = widthDiff/2;
			y = heigthDiff/2;
		}
		//02���Ͻ�
		else if(watermark_place.equals("02")){
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//03���Ͻ�
		else if(watermark_place.equals("03")){
			x = width - width1 - x;
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//04���½�
		else if(watermark_place.equals("04")){
			y = height - heigth1 - y;
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//05���½�
		else if(watermark_place.equals("05")){
			y = height - heigth1 - y;
			x = width - width1 - x;
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//06����
		else if(watermark_place.equals("06")){
			
		}
		
		Map<String, Integer>water_place =  new HashMap<String, Integer>();
		water_place.put("x", x);
		water_place.put("y", y);
		return water_place;
	}

	/**
	 * ��ȡˮӡ͸����
	 * @param watermark_angle
	 * @return
	 */
	public static float getWater_alpha(String watermark_angle) {
		float alpha = WaterMarkConstant.ALPHA;
		if(null==watermark_angle || "".equals(watermark_angle)){
			alpha = WaterMarkConstant.ALPHA;
		}else{
			alpha = (float) (Integer.valueOf(watermark_angle))/10 ;
		}
		return alpha;
		
	}

	/**
	 * ��תͼƬ�����ȣ�  ��ת����
	 * @param watermark_angle
	 * @return
	 */
	public static int getWatermark_angle(String page_val) {
		int watermark_angle = 0;
		if(null==page_val || "".equals(page_val)){
			watermark_angle = -30;
		}else{
			watermark_angle = Integer.valueOf(page_val);
		}
		return watermark_angle;
	}

	/**
	 * ��������Ŀ��
	 * @param font
	 * @return
	 */
	public static int getTextLength(String text) {
		int length = text.length();
		for(int i=0;i<text.length();i++){
			String s = String.valueOf(text.charAt(i));
			//�ֽڳ��ȴ���1 �����ַ�
			if(s.getBytes().length>1){
				length++;
			}
		}
		//2�ı���ֱ���۰�
		length = length%2==0?length/2:length;
		return length;
	}

	/**
	 * ˮӡ������ɫ����
	 * @param watermark_font_color
	 * @return
	 */
	public static Color getFont_color(String watermark_font_color) {
		Color font_color = WaterMarkConstant.FONT_COLOR_RED;
		if(null == watermark_font_color || watermark_font_color.equals("")){
			font_color = WaterMarkConstant.FONT_COLOR_RED;
		}
		//��
		else if(watermark_font_color.equals("01")){
			font_color = WaterMarkConstant.FONT_COLOR_RED;
		}
		//��
		else if(watermark_font_color.equals("02")){
			font_color = WaterMarkConstant.FONT_COLOR_YELLOW;
		}
		//��
		else if(watermark_font_color.equals("03")){
			font_color = WaterMarkConstant.FONT_COLOR_BLUE;
		}
		//��
		else if(watermark_font_color.equals("04")){
			font_color = WaterMarkConstant.FONT_COLOR_GREEN;
		}
		//��
		else if(watermark_font_color.equals("05")){
			font_color = WaterMarkConstant.FONT_COLOR_BLACK;
		}
		//��
		else if(watermark_font_color.equals("06")){
			font_color = WaterMarkConstant.FONT_COLOR_WHITE;
		}
		return font_color;
	}
	
}
