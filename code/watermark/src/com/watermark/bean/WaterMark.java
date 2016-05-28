package com.watermark.bean;

import java.io.File;

public class WaterMark {
    
	private File[] image;
	private String[] imageFileName;
	/**水印类型*/
	private String watermark_type = "";
	/**水印位置*/
	private String watermark_place = "";
	/**水印倾斜角度*/
	private String watermark_angle = "";
	/**水印文字*/
	private String watermark_font = "";
	/**水印文字大小*/
	private String watermark_font_size = "";
	/**水印文字颜色*/
	private String watermark_font_color = "";
	/**水印透明度*/
	private String watermark_alpha = "";
	/**图片位置*/
	private String uploadPath;
	
	
	public File[] getImage() {
		return image;
	}
	public void setImage(File[] image) {
		this.image = image;
	}
	public String[] getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getWatermark_type() {
		return watermark_type;
	}
	public void setWatermark_type(String watermark_type) {
		this.watermark_type = watermark_type;
	}
	public String getWatermark_place() {
		return watermark_place;
	}
	public void setWatermark_place(String watermark_place) {
		this.watermark_place = watermark_place;
	}
	public String getWatermark_angle() {
		return watermark_angle;
	}
	public void setWatermark_angle(String watermark_angle) {
		this.watermark_angle = watermark_angle;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getWatermark_alpha() {
		return watermark_alpha;
	}
	public void setWatermark_alpha(String watermark_alpha) {
		this.watermark_alpha = watermark_alpha;
	}
	public String getWatermark_font() {
		return watermark_font;
	}
	public void setWatermark_font(String watermark_font) {
		this.watermark_font = watermark_font;
	}
	public String getWatermark_font_size() {
		return watermark_font_size;
	}
	public void setWatermark_font_size(String watermark_font_size) {
		this.watermark_font_size = watermark_font_size;
	}
	public String getWatermark_font_color() {
		return watermark_font_color;
	}
	public void setWatermark_font_color(String watermark_font_color) {
		this.watermark_font_color = watermark_font_color;
	}
	
	
}
