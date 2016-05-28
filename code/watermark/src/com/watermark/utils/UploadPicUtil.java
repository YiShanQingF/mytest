package com.watermark.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.util.DateUtils;
import com.watermark.bean.WaterMark;
import com.watermark.common.WaterMarkConstant;

public class UploadPicUtil {

	
	public String uploadImage(File image, String imageFileName,String uploadPath, String realUploadPath, WaterMark waterMark){
		
		InputStream is = null;
		OutputStream os = null;
		
		DateUtils date = new DateUtils();
		//将源图片重命名
		imageFileName = date.getCurrTimeNoFormat() + imageFileName;
		try {
			is = new FileInputStream(image);
			os = new FileOutputStream(realUploadPath+"\\" + WaterMarkConstant.pic_path + "/" +imageFileName);
		
			byte [] buffer = new byte[1024];
			int len = 0;
			while( (len=is.read(buffer))>0  ){
				os.write(buffer);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return uploadPath+"\\" + WaterMarkConstant.pic_path + "/"+imageFileName;
	}
	
}
