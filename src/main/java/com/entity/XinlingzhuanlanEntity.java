package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 心灵专栏
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@TableName("xinlingzhuanlan")
public class XinlingzhuanlanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XinlingzhuanlanEntity() {
		
	}
	
	public XinlingzhuanlanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 专栏标题
	 */
					
	private String zhuanlanbiaoti;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：专栏标题
	 */
	public void setZhuanlanbiaoti(String zhuanlanbiaoti) {
		this.zhuanlanbiaoti = zhuanlanbiaoti;
	}
	/**
	 * 获取：专栏标题
	 */
	public String getZhuanlanbiaoti() {
		return zhuanlanbiaoti;
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
