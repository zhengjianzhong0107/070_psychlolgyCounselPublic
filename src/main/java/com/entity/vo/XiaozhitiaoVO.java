package com.entity.vo;

import com.entity.XiaozhitiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 小纸条
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
public class XiaozhitiaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 标题名称
	 */
	
	private String biaotimingcheng;
		
	/**
	 * 悄悄话
	 */
	
	private String qiaoqiaohua;
		
	/**
	 * 图片封面
	 */
	
	private String tupianfengmian;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
	/**
	 * 设置：标题名称
	 */
	 
	public void setBiaotimingcheng(String biaotimingcheng) {
		this.biaotimingcheng = biaotimingcheng;
	}
	
	/**
	 * 获取：标题名称
	 */
	public String getBiaotimingcheng() {
		return biaotimingcheng;
	}
				
	
	/**
	 * 设置：悄悄话
	 */
	 
	public void setQiaoqiaohua(String qiaoqiaohua) {
		this.qiaoqiaohua = qiaoqiaohua;
	}
	
	/**
	 * 获取：悄悄话
	 */
	public String getQiaoqiaohua() {
		return qiaoqiaohua;
	}
				
	
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
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
			
}
