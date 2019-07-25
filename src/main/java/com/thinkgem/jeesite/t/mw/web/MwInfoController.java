/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.t.mw.entity.MwInfo;
import com.thinkgem.jeesite.t.mw.service.MwInfoService;

/**
 * 劳模信息Controller
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
@Controller
@RequestMapping(value = "${adminPath}/mw/mwInfo")
public class MwInfoController extends BaseController {

	@Autowired
	private MwInfoService mwInfoService;
	
	@ModelAttribute
	public MwInfo get(@RequestParam(required=false) String id) {
		MwInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = mwInfoService.get(id);
		}
		if (entity == null){
			entity = new MwInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(MwInfo mwInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MwInfo> page = mwInfoService.findPage(new Page<MwInfo>(request, response), mwInfo); 
		model.addAttribute("page", page);
		return "t/mw/mwInfoList";
	}

	@RequestMapping(value = "form")
	public String form(MwInfo mwInfo, Model model) {
		model.addAttribute("mwInfo", mwInfo);
		return "t/mw/mwInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(MwInfo mwInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, mwInfo)){
			return form(mwInfo, model);
		}
		mwInfoService.save(mwInfo);
		addMessage(redirectAttributes, "保存劳模信息成功");
		return "redirect:"+Global.getAdminPath()+"/mw/mwInfo/?mwId="+mwInfo.getMwId();
	}
	
	@RequestMapping(value = "delete")
	public String delete(MwInfo mwInfo, RedirectAttributes redirectAttributes) {
		mwInfoService.delete(mwInfo);
		addMessage(redirectAttributes, "删除劳模信息成功");
		return "redirect:"+Global.getAdminPath()+"/mw/mwInfo/?mwId="+mwInfo.getMwId();
	}

}