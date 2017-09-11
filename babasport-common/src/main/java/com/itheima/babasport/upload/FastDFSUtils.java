package com.itheima.babasport.upload;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * 上传图片到fastDFS
 * @author Administrator
 *
 */
public class FastDFSUtils {
	
	//上传图片到FastDFS
	public static String uploadPic(byte[] pic,String name,long size) throws Exception{
		
		//获取配置文件路径
		ClassPathResource resource=new ClassPathResource("fdfs_client.conf");
		//加载配置文件
		ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
		//连接tracker
		TrackerClient trackerClient =new TrackerClient();
		//返回Storage的地址
		TrackerServer trackerServer=trackerClient.getConnection();
		//访问Storage
		StorageServer storageServer=null;
		StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
		//上传图片
		String ext = FilenameUtils.getExtension(name);
		//meta信息
		NameValuePair[] meta_list=new NameValuePair[3];
		meta_list[0]=new NameValuePair("filename",name);
		meta_list[1]=new NameValuePair("fileext",ext);
		meta_list[2]=new NameValuePair("filesize",String.valueOf(size));
		//上传并保存图片
		String path = storageClient1.upload_file1(pic, ext, meta_list);
		return path;
	}
}
