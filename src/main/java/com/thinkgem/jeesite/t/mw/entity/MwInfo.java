/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 劳模信息Entity
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
public class MwInfo extends DataEntity<MwInfo> {
	
	private static final long serialVersionUID = 1L;
	private String mwId;		// 劳模ID
	private String mwType;		// 劳模类型
	private Date mwDate;		// 奖励授予年份
	private String mwInfo;		// 奖励信息
	private String name;		// name
	
	public MwInfo() {
		super();
	}

	public MwInfo(String id){
		super(id);
	}

	public String getMwId() {
		return mwId;
	}

	public void setMwId(String mwId) {
		this.mwId = mwId;
	}
	
	public String getMwType() {
		return mwType;
	}

	public void setMwType(String mwType) {
		this.mwType = mwType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMwDate() {
		return mwDate;
	}

	public void setMwDate(Date mwDate) {
		this.mwDate = mwDate;
	}
	
	public String getMwInfo() {
		return mwInfo;
	}

	public void setMwInfo(String mwInfo) {
		this.mwInfo = mwInfo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}