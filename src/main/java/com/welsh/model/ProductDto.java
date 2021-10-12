package com.welsh.model;


import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Repository
public class ProductDto {

	private int no;
	private int productNumber;
	private String categoryCode;
	private String productName;
	private int productPrice;
	private int productStock;
	private String productDesc;
	private Date productDate;
	private int productHits;
	private String productImage;
	private String productRealImg;
}
 	  