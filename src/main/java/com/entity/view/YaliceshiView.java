package com.entity.view;

import com.entity.YaliceshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 压力测试
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@TableName("yaliceshi")
public class YaliceshiView  extends YaliceshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YaliceshiView(){
	}
 
 	public YaliceshiView(YaliceshiEntity yaliceshiEntity){
 	try {
			BeanUtils.copyProperties(this, yaliceshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
