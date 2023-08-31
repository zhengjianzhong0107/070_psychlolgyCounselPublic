package com.entity.view;

import com.entity.XinlingzhuanlanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 心灵专栏
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@TableName("xinlingzhuanlan")
public class XinlingzhuanlanView  extends XinlingzhuanlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinlingzhuanlanView(){
	}
 
 	public XinlingzhuanlanView(XinlingzhuanlanEntity xinlingzhuanlanEntity){
 	try {
			BeanUtils.copyProperties(this, xinlingzhuanlanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
