package com.common;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Util_index extends ActionSupport{
 
	private static final long serialVersionUID = 1L;

	public String util_index() throws Exception{
		String index_type = ServletActionContext.getRequest().getParameter("index_type");
		String re= "failure";
		if(null == index_type || "".equals(index_type)){
			re = "failure";
		}else if("0".equals(index_type)){
			re = "success_watermark";
		}
		return re;
	}

	
}
