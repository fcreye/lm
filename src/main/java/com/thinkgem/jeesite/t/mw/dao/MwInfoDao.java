/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.t.mw.entity.MwInfo;

/**
 * 劳模信息DAO接口
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
@MyBatisDao
public interface MwInfoDao extends CrudDao<MwInfo> {
	
}