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
public class MemberDto {

	private int no;
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userPhone;
	private String userAddress;
	private String emailCheck;
	private String userRole;
	private Date userInsertDate;
}
 	  