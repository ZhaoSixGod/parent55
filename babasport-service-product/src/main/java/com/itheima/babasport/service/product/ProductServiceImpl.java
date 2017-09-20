package com.itheima.babasport.service.product;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.babasport.dao.product.ProductDao;
import com.itheima.babasport.dao.product.SkuDao;
import com.itheima.babasport.pojo.product.Product;
import com.itheima.babasport.pojo.product.ProductQuery;
import com.itheima.babasport.pojo.product.ProductQuery.Criteria;
import com.itheima.babasport.pojo.product.Sku;

import cn.itcast.common.page.Pagination;

/**
 * 商品管理
 * 
 * @author Administrator
 *
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	
	// 通过上面的条件查询分页对象
	public Pagination selectPaginationByQuery(String name,Long brandId,Boolean isShow,Integer pageNo){
		
		ProductQuery productQuery=new ProductQuery();
		//当前页
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//每页数
		productQuery.setPageSize(10);
		//工程代码
		Criteria criteria = productQuery.createCriteria();
		//拼接地址
		StringBuilder params=new StringBuilder();
		//判断
		if(null !=name){
			criteria.andNameLike("%"+ name +"%");
			params.append("name=").append(name);
		}
		if(null != brandId){
			criteria.andBrandIdEqualTo(brandId);
			params.append("&brandId=").append(brandId);
		}
		if(null != brandId){
			criteria.andIsShowEqualTo(isShow);
			params.append("&isShow=").append(isShow);
		}else{
			//默认下架
			criteria.andIsShowEqualTo(false);
			params.append("&isShow=").append(false);
		}
		
		Pagination pagination= new Pagination(
					productQuery.getPageNo(),
					productQuery.getPageSize(),
					productDao.countByExample(productQuery)
				);
		//纠正一下当前页
		productQuery.setPageNo(pagination.getPageNo());
		pagination.setList(productDao.selectByExample(productQuery));
		
		//分页在页面上展示
		String url ="/product/list.do";
		pagination.pageView(url, params.toString());
		
		return pagination;
	}
	
	@Autowired
	private SkuDao skuDao;
	
	//保存商品表,返回id
	//保存库存表
	public void insertProduct(Product product){
		//保存商品时默认是下架
		product.setIsShow(false);
		//保存商品时默认是不删除
		product.setIsDel(true);
		//时间
		product.setCreateTime(new Date());
		//保存商品表
		productDao.insertSelective(product);
		//保存库存表
		//遍历颜色
		for(String colorId:product.getColors().split(",")){
			//遍历尺码
			for(String size:product.getSizes().split(",")){
				Sku sku=new Sku();
				//商品id
				sku.setProductId(product.getId());
				//颜色id
				sku.setColorId(Long.parseLong(colorId));
				//尺码
				sku.setSize(size);
				//价格
				sku.setPrice(0f);
				//运费
				sku.setDeliveFee(8f);
				//库存
				sku.setStock(0);
				//购买限制
				sku.setUpperLimit(200);
				//时间
				sku.setCreateTime(new Date());
				
				//保存
				skuDao.insertSelective(sku);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
