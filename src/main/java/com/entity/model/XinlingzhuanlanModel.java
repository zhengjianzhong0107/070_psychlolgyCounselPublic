package com.entity.model;

import com.entity.XinlingzhuanlanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 心灵专栏
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
public class XinlingzhuanlanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片封面
	 */
	
	private String tupianfengmian;
		
	/**
	 * 专栏分类
	 */
	
	private String zhuanlanfenlei;
		
	/**
	 * 专栏内容
	 */
	
	private String zhuanlanneirong;
		
	/**
	 * 发布时间
	 */
	
	private String fabushijian;
		
	/**
	 * 发布人
	 */
	
	private String faburen;
		
	/**
	 * 信息来源
	 */
	
	private String xinxilaiyuan;
				
	
	/**
	 * 设置：图片封面
	 */
	 
	public void setTupianfengmian(String tupianfengmian) {
		this.tupianfengmian = tupianfengmian;
	}
	
	/**
	 * 获取：图片封面
	 */
	public String getTupianfengmian() {
		return tupianfengmian;
	}
				
	
	/**
	 * 设置：专栏分类
	 */
	 
	public void setZhuanlanfenlei(String zhuanlanfenlei) {
		this.zhuanlanfenlei = zhuanlanfenlei;
	}
	
	/**
	 * 获取：专栏分类
	 */
	public String getZhuanlanfenlei() {
		return zhuanlanfenlei;
	}
				
	
	/**
	 * 设置：专栏内容
	 */
	 
	public void setZhuanlanneirong(String zhuanlanneirong) {
		this.zhuanlanneirong = zhuanlanneirong;
	}
	
	/**
	 * 获取：专栏内容
	 */
	public String getZhuanlanneirong() {
		return zhuanlanneirong;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(String fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public String getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：发布人
	 */
	 
	public void setFaburen(String faburen) {
		this.faburen = faburen;
	}
	
	/**
	 * 获取：发布人
	 */
	public String getFaburen() {
		return faburen;
	}
				
	
	/**
	 * 设置：信息来源
	 */
	 
	public void setXinxilaiyuan(String xinxilaiyuan) {
		this.xinxilaiyuan = xinxilaiyuan;
	}
	
	/**
	 * 获取：信息来源
	 */
	public String getXinxilaiyuan() {
		return xinxilaiyuan;
	}
			
}
