package com.entity.view;

import com.entity.XiaozhitiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 小纸条
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@TableName("xiaozhitiao")
public class XiaozhitiaoView  extends XiaozhitiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaozhitiaoView(){
	}
 
 	public XiaozhitiaoView(XiaozhitiaoEntity xiaozhitiaoEntity){
 	try {
			BeanUtils.copyProperties(this, xiaozhitiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
