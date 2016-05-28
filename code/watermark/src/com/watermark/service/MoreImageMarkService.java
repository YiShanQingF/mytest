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
	 * ��������Ŀ��
	 * @param text
	 * @return
	 */
	public int getTextLength(String text){
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
	 * @param image				ͼƬ����
	 * @param imageFileName		ͼƬ����
	 * @param uploadPath		���·��
	 * @param realUploadPath	���̾���·��
	 * 
	 * 01����ͼƬ�������
	 * 02����Java��ͼ���߶���
	 * 03ʹ�û�ͼ���߶���ԭͼ���Ƶ�����ͼƬ����
	 * 04ʹ�û�ͼ���߶���ˮӡ������/ͼƬ�����Ƶ�����ͼƬ��
	 * 05����ͼ����빤����
	 * 06ʹ��ͼ����빤�����������ͼ��Ŀ���ļ�
	 * 
	 * @return				ˮӡͼƬ
	 */
	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath,
			WaterMark waterMark) {
		DateUtils date = new DateUtils();
		imageFileName = date.getCurrTimeNoFormat() + imageFileName;
		String logoFileName = "logo_" + imageFileName ;
		OutputStream os = null;
		try {
			//ԭͼ �߿�     ˮӡ �߿�
			Map<String, Integer>water_pic = new HashMap<String, Integer>(); 
			Map<String, Integer>water_logo = new HashMap<String, Integer>(); 
			//ͼƬ�������      ��   ��     ��ɫ
			Image image2 = ImageIO.read(image);
			int width =image2.getWidth(null);
			int height = image2.getHeight(null);
			water_pic.put("width", width);
			water_pic.put("height", height);
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			//��ͼ���߶���
			Graphics2D graphics2d = bufferedImage.createGraphics();
			
			//ʹ�û�ͼ���߶���ԭͼ���Ƶ�����ͼƬ����
			//ͼƬ����  ������ԭͼһ��
			graphics2d.drawImage(image2, 0, 0, width, height, null);
			
			
			//��ȡˮӡ
			String logoPath = realUploadPath + "\\" + WaterMarkConstant.logo_path  + "/" + LOGO;
			File logo = new File(logoPath);
			Image logoImage = ImageIO.read(logo);
			//ˮӡ  ��  ��
			int width1 =logoImage.getWidth(null);
			int heigth1 = logoImage.getHeight(null);
			water_logo.put("width1", logoImage.getWidth(null));
			water_logo.put("height1", logoImage.getHeight(null));
			
			//͸��������
			//��ȡˮӡ͸����
			float alpha = (float) CommonUtils.getWater_alpha(waterMark.getWatermark_alpha());
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
			
			//��תͼƬ�����ȣ�  ��ת����
			int watermark_angle = CommonUtils.getWatermark_angle(waterMark.getWatermark_angle());
			graphics2d.rotate(Math.toRadians(watermark_angle), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
			//����x����y�������ʼֵ
			int x = -width/2;
			int y = -height/2;
			
			//��Ӷ��ˮӡ
			//ѭ��
			while(x<width*1.5){
				y = -height/2;
				while(y<height*1.5){
					graphics2d.drawImage(logoImage, x, y,null);
					y+= heigth1+300;
				}
				x += width1 +300;
			}
			
			graphics2d.dispose();
			
			//����ͼ����빤����
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
