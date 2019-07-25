/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.web;

import java.util.List;

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
import com.thinkgem.jeesite.t.mw.entity.ModelWorker;
import com.thinkgem.jeesite.t.mw.entity.MwInfo;
import com.thinkgem.jeesite.t.mw.service.ModelWorkerService;
import com.thinkgem.jeesite.t.mw.service.MwInfoService;

/**
 * 劳动模范Controller
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
@Controller
@RequestMapping(value = "${frontPath}/mw/")
public class MWPublicController extends BaseController {

	@Autowired
	private ModelWorkerService modelWorkerService;
	@Autowired
	private MwInfoService mWInfoService;
	
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
	
	@RequestMapping(value = "list")
	public String list(ModelWorker modelWorker, HttpServletRequest request, HttpServletResponse response, Model model) {
		String remarks =modelWorker.getRemarks();
		if(remarks!=null) {
			modelWorker.setRemarks(remarks.toUpperCase());
		}
		String mwType = modelWorker.getNameC();
		String a = "";
		if(mwType!=null&&!"".equals(mwType)) {
			switch (mwType) {
			case "1": a="北京市劳模";break;
			case "2": a="部级劳模";break;
			case "3": a="全国劳模";break;
			case "4": a="全国五一劳动奖章";break;
			case "5": a="外省市劳模";break;
			case "6": a="享受北京市级劳模待遇";break;
			case "7": a="享受全国劳模待遇";
			}
		}
		modelWorker.setNameC(a);
		
		Page<ModelWorker> page = modelWorkerService.findPage(new Page<ModelWorker>(request, response), modelWorker); 
		model.addAttribute("page", page);
		modelWorker.setNameC(mwType);
		model.addAttribute("modelWorker", modelWorker);
		return "t/mw/modelWorkerListPublic";
	}
	@RequestMapping(value ="index")
	public String index(ModelWorker modelWorker, HttpServletRequest request, HttpServletResponse response, Model model) {
		return "t/mw/index";
	}

	@RequestMapping(value = "context")
	public String context(ModelWorker modelWorker, Model model) {
		modelWorker = modelWorkerService.get(modelWorker);
		
		String mwId = modelWorker.getId();
		
		MwInfo mwInfo = new MwInfo();
		
		mwInfo.setMwId(mwId);
		
		List<MwInfo> infos =mWInfoService.findList(mwInfo);
		model.addAttribute("mw", modelWorker);
		model.addAttribute("infos", infos);
		return "t/mw/mwInfo";
	}
}