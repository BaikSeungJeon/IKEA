package com.welsh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welsh.model.ProductDao;
import com.welsh.model.ProductDto;



@Controller
public class ProductController {

	@Autowired
	ProductDto productDto;
	
	@Autowired
	ProductDao productDao;
	
	
	
	
	@RequestMapping("/ProductJsonList.do")
	@ResponseBody
	public Map<String,Object> galleryJsonList() {
		
		Map<String,Object> hashMap =null;
		
		
		//int totalReply=0;
		
		//int boardId=replyDto.getBoardId();
		//totalReply=replyDao.getTotalReply(boardId);
		
		
		List<ProductDto> productList =productDao.getAllProduct();
		hashMap = new HashMap<String,Object>();
		//log.info("galleryList={}",galleryList);
		hashMap.put("galleryList", productList);
		//hashMap.put("totalReply", totalReply);
		return hashMap;
	}
	
	@RequestMapping("/List1.do")
	public String list1() {
		return "list1";
	}
}
