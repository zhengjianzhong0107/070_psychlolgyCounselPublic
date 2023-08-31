package com.entity.model;

import com.entity.YaliceshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 压力测试
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
public class YaliceshiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 简介
	 */
	
	private String jianjie;
		
	/**
	 * 题目1
	 */
	
	private String timu1;
		
	/**
	 * 题目2
	 */
	
	private String timu2;
		
	/**
	 * 题目3
	 */
	
	private String timu3;
		
	/**
	 * 题目4
	 */
	
	private String timu4;
		
	/**
	 * 题目5
	 */
	
	private String timu5;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	
	/**
	 * 获取：简介
	 */
	public String getJianjie() {
		return jianjie;
	}
				
	
	/**
	 * 设置：题目1
	 */
	 
	public void setTimu1(String timu1) {
		this.timu1 = timu1;
	}
	
	/**
	 * 获取：题目1
	 */
	public String getTimu1() {
		return timu1;
	}
				
	
	/**
	 * 设置：题目2
	 */
	 
	public void setTimu2(String timu2) {
		this.timu2 = timu2;
	}
	
	/**
	 * 获取：题目2
	 */
	public String getTimu2() {
		return timu2;
	}
				
	
	/**
	 * 设置：题目3
	 */
	 
	public void setTimu3(String timu3) {
		this.timu3 = timu3;
	}
	
	/**
	 * 获取：题目3
	 */
	public String getTimu3() {
		return timu3;
	}
				
	
	/**
	 * 设置：题目4
	 */
	 
	public void setTimu4(String timu4) {
		this.timu4 = timu4;
	}
	
	/**
	 * 获取：题目4
	 */
	public String getTimu4() {
		return timu4;
	}
				
	
	/**
	 * 设置：题目5
	 */
	 
	public void setTimu5(String timu5) {
		this.timu5 = timu5;
	}
	
	/**
	 * 获取：题目5
	 */
	public String getTimu5() {
		return timu5;
	}
			
}
