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
 * 压力测试
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@TableName("yaliceshi")
public class YaliceshiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YaliceshiEntity() {
		
	}
	
	public YaliceshiEntity(T t) {
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
	 * 测试名称
	 */
					
	private String ceshimingcheng;
	
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
