
package com.test.microservices.customers.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Model class of controller
 * @author Angel
 *
 */
@Document(collection = "users")
@JsonPropertyOrder({"userId", "name"})
@ApiModel("Model User")
public class User implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @NotNull

	@ApiModelProperty(value = "the user's id", required = true)
    private String userId;
    @NotNull


	@ApiModelProperty(value = "the user's name", required = true)
    private String name;

	@ApiModelProperty(value = "the user's sex", required = true)
	private String sex;

	@ApiModelProperty(value = "the user's birthdate", required = true)
	private String birthDate;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}   
}
