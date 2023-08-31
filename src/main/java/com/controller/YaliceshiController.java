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

import com.entity.YaliceshiEntity;
import com.entity.view.YaliceshiView;

import com.service.YaliceshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 压力测试
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-19 21:46:13
 */
@RestController
@RequestMapping("/yaliceshi")
public class YaliceshiController {
    @Autowired
    private YaliceshiService yaliceshiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YaliceshiEntity yaliceshi, HttpServletRequest request){
        EntityWrapper<YaliceshiEntity> ew = new EntityWrapper<YaliceshiEntity>();
		PageUtils page = yaliceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaliceshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YaliceshiEntity yaliceshi, HttpServletRequest request){
        EntityWrapper<YaliceshiEntity> ew = new EntityWrapper<YaliceshiEntity>();
		PageUtils page = yaliceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaliceshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YaliceshiEntity yaliceshi){
       	EntityWrapper<YaliceshiEntity> ew = new EntityWrapper<YaliceshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yaliceshi, "yaliceshi")); 
        return R.ok().put("data", yaliceshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YaliceshiEntity yaliceshi){
        EntityWrapper< YaliceshiEntity> ew = new EntityWrapper< YaliceshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yaliceshi, "yaliceshi")); 
		YaliceshiView yaliceshiView =  yaliceshiService.selectView(ew);
		return R.ok("查询压力测试成功").put("data", yaliceshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YaliceshiEntity yaliceshi = yaliceshiService.selectById(id);
        return R.ok().put("data", yaliceshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YaliceshiEntity yaliceshi = yaliceshiService.selectById(id);
        return R.ok().put("data", yaliceshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YaliceshiEntity yaliceshi, HttpServletRequest request){
    	yaliceshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaliceshi);
        yaliceshiService.insert(yaliceshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YaliceshiEntity yaliceshi, HttpServletRequest request){
    	yaliceshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaliceshi);
        yaliceshiService.insert(yaliceshi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YaliceshiEntity yaliceshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaliceshi);
        yaliceshiService.updateById(yaliceshi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yaliceshiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YaliceshiEntity> wrapper = new EntityWrapper<YaliceshiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yaliceshiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
