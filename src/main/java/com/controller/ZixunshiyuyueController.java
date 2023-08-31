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

import com.entity.ZixunshiyuyueEntity;
import com.entity.view.ZixunshiyuyueView;

import com.service.ZixunshiyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 咨询师预约
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@RestController
@RequestMapping("/zixunshiyuyue")
public class ZixunshiyuyueController {
    @Autowired
    private ZixunshiyuyueService zixunshiyuyueService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunshiyuyueEntity zixunshiyuyue, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xinlizixunshi")) {
			zixunshiyuyue.setZixunshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zixunshiyuyue.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunshiyuyueEntity> ew = new EntityWrapper<ZixunshiyuyueEntity>();
		PageUtils page = zixunshiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunshiyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunshiyuyueEntity zixunshiyuyue, HttpServletRequest request){
        EntityWrapper<ZixunshiyuyueEntity> ew = new EntityWrapper<ZixunshiyuyueEntity>();
		PageUtils page = zixunshiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunshiyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunshiyuyueEntity zixunshiyuyue){
       	EntityWrapper<ZixunshiyuyueEntity> ew = new EntityWrapper<ZixunshiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunshiyuyue, "zixunshiyuyue")); 
        return R.ok().put("data", zixunshiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunshiyuyueEntity zixunshiyuyue){
        EntityWrapper< ZixunshiyuyueEntity> ew = new EntityWrapper< ZixunshiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunshiyuyue, "zixunshiyuyue")); 
		ZixunshiyuyueView zixunshiyuyueView =  zixunshiyuyueService.selectView(ew);
		return R.ok("查询咨询师预约成功").put("data", zixunshiyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunshiyuyueEntity zixunshiyuyue = zixunshiyuyueService.selectById(id);
        return R.ok().put("data", zixunshiyuyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunshiyuyueEntity zixunshiyuyue = zixunshiyuyueService.selectById(id);
        return R.ok().put("data", zixunshiyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunshiyuyueEntity zixunshiyuyue, HttpServletRequest request){
    	zixunshiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunshiyuyue);
        zixunshiyuyueService.insert(zixunshiyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunshiyuyueEntity zixunshiyuyue, HttpServletRequest request){
    	zixunshiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunshiyuyue);
        zixunshiyuyueService.insert(zixunshiyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZixunshiyuyueEntity zixunshiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunshiyuyue);
        zixunshiyuyueService.updateById(zixunshiyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunshiyuyueService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZixunshiyuyueEntity> wrapper = new EntityWrapper<ZixunshiyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xinlizixunshi")) {
			wrapper.eq("zixunshizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = zixunshiyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
