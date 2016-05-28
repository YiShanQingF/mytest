package com.watermark.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.watermark.bean.PicInfo;
import com.watermark.bean.WaterMark;
import com.watermark.service.ImageMarkService;
import com.watermark.service.MarkService;
import com.watermark.service.MoreImageMarkService;
import com.watermark.service.MoreTextMarkService;
import com.watermark.service.TextMarkService;
import com.watermark.utils.UploadPicUtil;

@SuppressWarnings("serial")
public class WaterMarkAction extends ActionSupport implements ModelDriven<WaterMark>{

	private WaterMark waterMark = new WaterMark();
	@Override
	public WaterMark getModel() {
		//ʹ��ModelDriven  ����ʵ��������
		return waterMark;
	}
	private List<PicInfo> picInfo = new ArrayList<PicInfo>();
	public String watermark() throws Exception{
		
		
		//���Ͻ�
//		MarkService markService = new ImageMarkService();
		//45��ƽ��
//		MarkService markService = new MoreImageMarkService();
		//����45��  ƽ��
//		MarkService markService = new MoreTextMarkService();
		//����45��  ���Ͻ�
//		MarkService markService = new TextMarkService();
		
		MarkService markService = null;
		
		String watermark_type = waterMark.getWatermark_type();
		String watermark_place = waterMark.getWatermark_place();
		if(null!=watermark_type && watermark_type.equals("01")){
			if( null!=watermark_place && watermark_place.equals("06") ){
				markService = new MoreImageMarkService();
			}else{
				markService = new ImageMarkService();
			}
		}else{
			if( null!=watermark_place && watermark_place.equals("06") ){
				markService = new MoreTextMarkService();
			}else{
				markService = new TextMarkService();
			}
		}
		
		File[] image = waterMark.getImage();
		String[] imageFileName = waterMark.getImageFileName();
		String uploadPath = waterMark.getUploadPath();
		String realUploadPath = ServletActionContext.getServletContext().getRealPath(uploadPath);
		//�����ϴ���ͼƬ�ļ�
		UploadPicUtil uploadService = new UploadPicUtil();
		if( null!=image	&& image.length>0){
			for(int i=0;i<image.length;i++){
				PicInfo pi = new PicInfo();
				String url = uploadService.uploadImage(image[i], imageFileName[i], uploadPath, realUploadPath,waterMark);
				pi.setImageURL(url);
				
				String logoImageURL = markService.watermark(image[i], imageFileName[i], uploadPath, realUploadPath,waterMark);
				pi.setLogoImageURL(logoImageURL);
				
				picInfo.add(pi);
			}
		}
		
		return SUCCESS;
	}


	public List<PicInfo> getPicInfo() {
		return picInfo;
	}
	public void setPicInfo(List<PicInfo> picInfo) {
		this.picInfo = picInfo;
	}
	public WaterMark getWaterMark() {
		return waterMark;
	}
	public void setWaterMark(WaterMark waterMark) {
		this.waterMark = waterMark;
	}


	

}
