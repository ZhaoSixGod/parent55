package com.itheima.babasport.service.product;

import com.itheima.babasport.pojo.product.Brand;

public interface UploadService {
	
	//文件系统
	public String uploadPic(byte[] pic,String name,long size) throws Exception; 
	
	
}
