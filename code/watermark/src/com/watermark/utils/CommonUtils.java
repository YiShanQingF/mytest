package com.watermark.utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.watermark.common.WaterMarkConstant;

public class CommonUtils {

	/**
	 * 获取水印位置
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
		//水印位置
		int x = WaterMarkConstant.X;
		int y = WaterMarkConstant.Y;
		if(null==watermark_place || "".equals(watermark_place)){
			//保证水印在图片的右下角
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//01居中
		else if(watermark_place.equals("01")){
			x = widthDiff/2;
			y = heigthDiff/2;
		}
		//02左上角
		else if(watermark_place.equals("02")){
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//03右上角
		else if(watermark_place.equals("03")){
			x = width - width1 - x;
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//04左下角
		else if(watermark_place.equals("04")){
			y = height - heigth1 - y;
			if(x>widthDiff){
				x = widthDiff;
			}
			if(y>heigthDiff){
				y=heigthDiff;
			}
		}
		//05右下角
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
		//06铺满
		else if(watermark_place.equals("06")){
			
		}
		
		Map<String, Integer>water_place =  new HashMap<String, Integer>();
		water_place.put("x", x);
		water_place.put("y", y);
		return water_place;
	}

	/**
	 * 获取水印透明度
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
	 * 旋转图片（弧度）  旋转中心
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
	 * 计算字体的宽度
	 * @param font
	 * @return
	 */
	public static int getTextLength(String text) {
		int length = text.length();
		for(int i=0;i<text.length();i++){
			String s = String.valueOf(text.charAt(i));
			//字节长度大于1 中文字符
			if(s.getBytes().length>1){
				length++;
			}
		}
		//2的倍数直接折半
		length = length%2==0?length/2:length;
		return length;
	}

	/**
	 * 水印文字颜色设置
	 * @param watermark_font_color
	 * @return
	 */
	public static Color getFont_color(String watermark_font_color) {
		Color font_color = WaterMarkConstant.FONT_COLOR_RED;
		if(null == watermark_font_color || watermark_font_color.equals("")){
			font_color = WaterMarkConstant.FONT_COLOR_RED;
		}
		//红
		else if(watermark_font_color.equals("01")){
			font_color = WaterMarkConstant.FONT_COLOR_RED;
		}
		//黄
		else if(watermark_font_color.equals("02")){
			font_color = WaterMarkConstant.FONT_COLOR_YELLOW;
		}
		//蓝
		else if(watermark_font_color.equals("03")){
			font_color = WaterMarkConstant.FONT_COLOR_BLUE;
		}
		//绿
		else if(watermark_font_color.equals("04")){
			font_color = WaterMarkConstant.FONT_COLOR_GREEN;
		}
		//黑
		else if(watermark_font_color.equals("05")){
			font_color = WaterMarkConstant.FONT_COLOR_BLACK;
		}
		//白
		else if(watermark_font_color.equals("06")){
			font_color = WaterMarkConstant.FONT_COLOR_WHITE;
		}
		return font_color;
	}
	
}
