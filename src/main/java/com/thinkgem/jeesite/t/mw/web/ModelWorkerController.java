/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
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
import com.thinkgem.jeesite.t.mw.entity.ModelWorker;
import com.thinkgem.jeesite.t.mw.service.ModelWorkerService;

/**
 * 劳动模范Controller
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
@Controller
@RequestMapping(value = "${adminPath}/mw/modelWorker")
public class ModelWorkerController extends BaseController {

	@Autowired
	private ModelWorkerService modelWorkerService;
	
	@ModelAttribute
	public ModelWorker get(@RequestParam(required=false) String id) {
		ModelWorker entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = modelWorkerService.get(id);
		}
		if (entity == null){
			entity = new ModelWorker();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ModelWorker modelWorker, HttpServletRequest request, HttpServletResponse response, Model model) {
		String remarks =modelWorker.getRemarks();
		if(remarks!=null) {
			modelWorker.setRemarks(remarks.toUpperCase());
		}
		Page<ModelWorker> page = modelWorkerService.findPage(new Page<ModelWorker>(request, response), modelWorker); 
		model.addAttribute("page", page);
		return "t/mw/modelWorkerList";
	}

	@RequestMapping(value = "form")
	public String form(ModelWorker modelWorker, Model model) {
		model.addAttribute("modelWorker", modelWorker);
		return "t/mw/modelWorkerForm";
	}

	@RequestMapping(value = "save")
	public String save(ModelWorker modelWorker, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, modelWorker)){
			return form(modelWorker, model);
		}
		String name = modelWorker.getName();
		String nameD = modelWorker.getNameD();
		String nameC = modelWorker.getNameC();
		if(nameD!=null) {
			nameD = nameD.toUpperCase();
		}
		if(nameC!=null) {
			nameC = nameC.toUpperCase();
		}
		String remarks = name+nameD+nameC;
		modelWorker.setRemarks(remarks);
		
		String content = modelWorker.getContent();
		if(content!=null&&!"".equals(content)) {
			content = StringEscapeUtils.unescapeHtml3(content);
		}
		modelWorker.setContent(content);
		modelWorkerService.save(modelWorker);
		addMessage(redirectAttributes, "保存劳动模范成功");
		return "redirect:"+Global.getAdminPath()+"/mw/modelWorker/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(ModelWorker modelWorker, RedirectAttributes redirectAttributes) {
		modelWorkerService.delete(modelWorker);
		addMessage(redirectAttributes, "删除劳动模范成功");
		return "redirect:"+Global.getAdminPath()+"/mw/modelWorker/?repage";
	}

}