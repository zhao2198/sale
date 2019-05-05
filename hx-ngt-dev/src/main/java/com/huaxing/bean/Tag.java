package com.huaxing.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

	private long id;
	private String name;
	private String status;
	private double price;
	private Book book;
}
