package com.entity.vo;

import com.entity.CeshishujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 测试数据
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
public class CeshishujuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 测试名称
	 */
	
	private String ceshimingcheng;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 回答1
	 */
	
	private String huida1;
		
	/**
	 * 回答2
	 */
	
	private String huida2;
		
	/**
	 * 回答3
	 */
	
	private String huida3;
		
	/**
	 * 回答4
	 */
	
	private String huida4;
		
	/**
	 * 回答5
	 */
	
	private String huida5;
				
	
	/**
	 * 设置：测试名称
	 */
	 
	public void setCeshimingcheng(String ceshimingcheng) {
		this.ceshimingcheng = ceshimingcheng;
	}
	
	/**
	 * 获取：测试名称
	 */
	public String getCeshimingcheng() {
		return ceshimingcheng;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：回答1
	 */
	 
	public void setHuida1(String huida1) {
		this.huida1 = huida1;
	}
	
	/**
	 * 获取：回答1
	 */
	public String getHuida1() {
		return huida1;
	}
				
	
	/**
	 * 设置：回答2
	 */
	 
	public void setHuida2(String huida2) {
		this.huida2 = huida2;
	}
	
	/**
	 * 获取：回答2
	 */
	public String getHuida2() {
		return huida2;
	}
				
	
	/**
	 * 设置：回答3
	 */
	 
	public void setHuida3(String huida3) {
		this.huida3 = huida3;
	}
	
	/**
	 * 获取：回答3
	 */
	public String getHuida3() {
		return huida3;
	}
				
	
	/**
	 * 设置：回答4
	 */
	 
	public void setHuida4(String huida4) {
		this.huida4 = huida4;
	}
	
	/**
	 * 获取：回答4
	 */
	public String getHuida4() {
		return huida4;
	}
				
	
	/**
	 * 设置：回答5
	 */
	 
	public void setHuida5(String huida5) {
		this.huida5 = huida5;
	}
	
	/**
	 * 获取：回答5
	 */
	public String getHuida5() {
		return huida5;
	}
			
}
