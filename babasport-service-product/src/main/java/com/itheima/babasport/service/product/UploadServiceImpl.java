package com.itheima.babasport.service.product;

import org.springframework.stereotype.Service;

import com.itheima.babasport.dao.product.BrandDao;
import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.upload.FastDFSUtils;

/**
 * 上传图片的服务
 * @author Administrator
 *
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {
	
	//文件系统
	public String uploadPic(byte[] pic,String name,long size) throws Exception{
		//上传开始
		return FastDFSUtils.uploadPic(pic, name, size);
	}

	
}
