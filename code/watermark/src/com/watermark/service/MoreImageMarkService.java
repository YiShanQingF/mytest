package com.watermark.service;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.util.DateUtils;
import com.watermark.bean.WaterMark;
import com.watermark.common.WaterMarkConstant;
import com.watermark.utils.CommonUtils;

public class MoreImageMarkService implements MarkService{
	
	/**
	 * 计算字体的宽度
	 * @param text
	 * @return
	 */
	public int getTextLength(String text){
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
	 * @param image				图片对象
	 * @param imageFileName		图片名称
	 * @param uploadPath		相对路径
	 * @param realUploadPath	磁盘绝对路径
	 * 
	 * 01创建图片缓存对象
	 * 02创建Java绘图工具对象
	 * 03使用绘图工具对象将原图绘制到缓存图片对象
	 * 04使用绘图工具对象将水印（文字/图片）绘制到缓存图片中
	 * 05创建图像编码工具类
	 * 06使用图像编码工具类输出缓存图像到目标文件
	 * 
	 * @return				水印图片
	 */
	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath,
			WaterMark waterMark) {
		DateUtils date = new DateUtils();
		imageFileName = date.getCurrTimeNoFormat() + imageFileName;
		String logoFileName = "logo_" + imageFileName ;
		OutputStream os = null;
		try {
			//原图 高宽     水印 高宽
			Map<String, Integer>water_pic = new HashMap<String, Integer>(); 
			Map<String, Integer>water_logo = new HashMap<String, Integer>(); 
			//图片缓存对象      高   宽     颜色
			Image image2 = ImageIO.read(image);
			int width =image2.getWidth(null);
			int height = image2.getHeight(null);
			water_pic.put("width", width);
			water_pic.put("height", height);
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			//绘图工具对象
			Graphics2D graphics2d = bufferedImage.createGraphics();
			
			//使用绘图工具对象将原图绘制到缓存图片对象
			//图片对象  坐标与原图一致
			graphics2d.drawImage(image2, 0, 0, width, height, null);
			
			
			//获取水印
			String logoPath = realUploadPath + "\\" + WaterMarkConstant.logo_path  + "/" + LOGO;
			File logo = new File(logoPath);
			Image logoImage = ImageIO.read(logo);
			//水印  高  宽
			int width1 =logoImage.getWidth(null);
			int heigth1 = logoImage.getHeight(null);
			water_logo.put("width1", logoImage.getWidth(null));
			water_logo.put("height1", logoImage.getHeight(null));
			
			//透明度设置
			//获取水印透明度
			float alpha = (float) CommonUtils.getWater_alpha(waterMark.getWatermark_alpha());
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
			
			//旋转图片（弧度）  旋转中心
			int watermark_angle = CommonUtils.getWatermark_angle(waterMark.getWatermark_angle());
			graphics2d.rotate(Math.toRadians(watermark_angle), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
			//设置x坐标y坐标的起始值
			int x = -width/2;
			int y = -height/2;
			
			//添加多个水印
			//循环
			while(x<width*1.5){
				y = -height/2;
				while(y<height*1.5){
					graphics2d.drawImage(logoImage, x, y,null);
					y+= heigth1+300;
				}
				x += width1 +300;
			}
			
			graphics2d.dispose();
			
			//创建图像编码工具类
			os = new FileOutputStream(realUploadPath + "\\" + WaterMarkConstant.logo_pic_path  +"/"+logoFileName);
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(bufferedImage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return uploadPath + "\\" + WaterMarkConstant.logo_pic_path  + "/" + logoFileName;
	}
	
	

}
