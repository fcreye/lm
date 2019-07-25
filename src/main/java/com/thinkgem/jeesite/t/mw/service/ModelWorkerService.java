/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.t.mw.entity.ModelWorker;
import com.thinkgem.jeesite.t.mw.dao.ModelWorkerDao;

/**
 * 劳动模范Service
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
@Service
@Transactional(readOnly = true)
public class ModelWorkerService extends CrudService<ModelWorkerDao, ModelWorker> {

	public ModelWorker get(String id) {
		return super.get(id);
	}
	
	public List<ModelWorker> findList(ModelWorker modelWorker) {
		return super.findList(modelWorker);
	}
	
	public Page<ModelWorker> findPage(Page<ModelWorker> page, ModelWorker modelWorker) {
		return super.findPage(page, modelWorker);
	}
	
	@Transactional(readOnly = false)
	public void save(ModelWorker modelWorker) {
		super.save(modelWorker);
	}
	
	@Transactional(readOnly = false)
	public void delete(ModelWorker modelWorker) {
		super.delete(modelWorker);
	}
	
}