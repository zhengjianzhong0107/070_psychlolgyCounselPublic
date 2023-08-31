package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiaozhitiaoEntity;
import com.entity.view.XiaozhitiaoView;

import com.service.XiaozhitiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 小纸条
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@RestController
@RequestMapping("/xiaozhitiao")
public class XiaozhitiaoController {
    @Autowired
    private XiaozhitiaoService xiaozhitiaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaozhitiaoEntity xiaozhitiao, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xiaozhitiao.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaozhitiaoEntity> ew = new EntityWrapper<XiaozhitiaoEntity>();
		PageUtils page = xiaozhitiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaozhitiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaozhitiaoEntity xiaozhitiao, HttpServletRequest request){
        EntityWrapper<XiaozhitiaoEntity> ew = new EntityWrapper<XiaozhitiaoEntity>();
		PageUtils page = xiaozhitiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaozhitiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaozhitiaoEntity xiaozhitiao){
       	EntityWrapper<XiaozhitiaoEntity> ew = new EntityWrapper<XiaozhitiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaozhitiao, "xiaozhitiao")); 
        return R.ok().put("data", xiaozhitiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaozhitiaoEntity xiaozhitiao){
        EntityWrapper< XiaozhitiaoEntity> ew = new EntityWrapper< XiaozhitiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaozhitiao, "xiaozhitiao")); 
		XiaozhitiaoView xiaozhitiaoView =  xiaozhitiaoService.selectView(ew);
		return R.ok("查询小纸条成功").put("data", xiaozhitiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaozhitiaoEntity xiaozhitiao = xiaozhitiaoService.selectById(id);
        return R.ok().put("data", xiaozhitiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaozhitiaoEntity xiaozhitiao = xiaozhitiaoService.selectById(id);
        return R.ok().put("data", xiaozhitiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaozhitiaoEntity xiaozhitiao, HttpServletRequest request){
    	xiaozhitiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaozhitiao);
        xiaozhitiaoService.insert(xiaozhitiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaozhitiaoEntity xiaozhitiao, HttpServletRequest request){
    	xiaozhitiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaozhitiao);
        xiaozhitiaoService.insert(xiaozhitiao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XiaozhitiaoEntity xiaozhitiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaozhitiao);
        xiaozhitiaoService.updateById(xiaozhitiao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaozhitiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XiaozhitiaoEntity> wrapper = new EntityWrapper<XiaozhitiaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = xiaozhitiaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
