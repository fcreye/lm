/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.t.mw.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 劳动模范Entity
 * @author 李存刚18801207037
 * @version 2018-06-20
 */
public class ModelWorker extends DataEntity<ModelWorker> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String sex;		// 性别
	private Date birthday;		// 出生日期
	private String idCode;		// 身份证号
	private String org;		// 工作单位
	private String image;		// 头像
	private String content;		// 简要事迹
	private String nameD;		// name_d
	private String nameC;		// name_c
	
	public ModelWorker() {
		super();
	}

	public ModelWorker(String id){
		super(id);
	}

	@Length(min=1, max=255, message="姓名长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=1, message="性别长度必须介于 1 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="出生日期不能为空")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=1, max=18, message="身份证号长度必须介于 1 和 18 之间")
	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	
	@Length(min=0, max=255, message="工作单位长度必须介于 0 和 255 之间")
	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}
	
	@Length(min=0, max=255, message="头像长度必须介于 0 和 255 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=32, message="name_d长度必须介于 1 和 32 之间")
	public String getNameD() {
		return nameD;
	}

	public void setNameD(String nameD) {
		this.nameD = nameD;
	}
	
	@Length(min=1, max=32, message="name_c长度必须介于 1 和 32 之间")
	public String getNameC() {
		return nameC;
	}

	public void setNameC(String nameC) {
		this.nameC = nameC;
	}
	
}