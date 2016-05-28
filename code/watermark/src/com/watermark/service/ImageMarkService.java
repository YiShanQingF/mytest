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

public class ImageMarkService implements MarkService {

	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath,WaterMark waterMark) {
		
		DateUtils date = new DateUtils();
		imageFileName = date.getCurrTimeNoFormat() + imageFileName;
		String logoFileName = "logo_" + imageFileName ;
		OutputStream os = null;
		String logoPath = realUploadPath + "\\" + WaterMarkConstant.logo_path  + "/" + WaterMarkConstant.LOGO;
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
			
			//读取水印
			File logo = new File(logoPath);
			Image imagelogo = ImageIO.read(logo);
			water_logo.put("width1", imagelogo.getWidth(null));
			water_logo.put("height1", imagelogo.getHeight(null));
			//水印位置
			int x = WaterMarkConstant.X;
			int y = WaterMarkConstant.Y;
			//获取水印位置
			Map<String, Integer>water_place = CommonUtils.getWater_place(waterMark.getWatermark_place(),water_pic,water_logo);
			x = water_place.get("x");
			y = water_place.get("y");
			//获取水印透明度
			float alpha = (float) CommonUtils.getWater_alpha(waterMark.getWatermark_alpha());
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
			
			graphics2d.drawImage(imagelogo, x, y, null);
			graphics2d.dispose();
			
			//创建图像编码工具类
			os = new FileOutputStream(realUploadPath + "\\" + WaterMarkConstant.logo_pic_path +"/"+logoFileName);
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
		return uploadPath + "\\" + WaterMarkConstant.logo_pic_path + "/" + logoFileName;
	}
	
}
