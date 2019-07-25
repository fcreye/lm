/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.t.mw.entity.MwInfo;
import com.thinkgem.jeesite.t.mw.dao.MwInfoDao;

/**
 * 劳模信息Service
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
@Service
@Transactional(readOnly = true)
public class MwInfoService extends CrudService<MwInfoDao, MwInfo> {

	public MwInfo get(String id) {
		return super.get(id);
	}
	
	public List<MwInfo> findList(MwInfo mwInfo) {
		return super.findList(mwInfo);
	}
	
	public Page<MwInfo> findPage(Page<MwInfo> page, MwInfo mwInfo) {
		return super.findPage(page, mwInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(MwInfo mwInfo) {
		super.save(mwInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(MwInfo mwInfo) {
		super.delete(mwInfo);
	}
	
}