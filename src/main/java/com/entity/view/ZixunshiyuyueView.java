package com.entity.view;

import com.entity.ZixunshiyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 咨询师预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@TableName("zixunshiyuyue")
public class ZixunshiyuyueView  extends ZixunshiyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZixunshiyuyueView(){
	}
 
 	public ZixunshiyuyueView(ZixunshiyuyueEntity zixunshiyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, zixunshiyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
