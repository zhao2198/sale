package com.huaxing.bean;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.common.entity.IdEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class Book extends IdEntity {

	private static final long serialVersionUID = 1L;
	@Length(max = 10, min = 5, message = "书名需在5-10之间")
	private String bookName;
	@DecimalMax(value = "10.5")
	private Double price;
	@Max(value = 100)
	private Integer bookType;
	private String author;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	private Date modifyDate;

	// for select

}
