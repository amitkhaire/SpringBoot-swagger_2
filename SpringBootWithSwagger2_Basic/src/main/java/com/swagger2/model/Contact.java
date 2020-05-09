package com.swagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the contact class")
public class Contact {

	@ApiModelProperty(notes = "uniq id for contact")
	private String id;
	@ApiModelProperty(notes = "Name for contact")
	private String name;
	@ApiModelProperty(notes = "address for contact")
	private String addres;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

}
