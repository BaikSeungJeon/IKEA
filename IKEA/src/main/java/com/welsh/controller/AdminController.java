package com.welsh.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.welsh.model.ProductDao;
import com.welsh.model.ProductDto;
import com.welsh.utils.ScriptWriterUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController {


	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("/AdminPage.do")
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/RegisterItemForm.do")
	public String registerItemForm() {
		return "registerItem";
	}
	
	@ResponseBody
	@RequestMapping("/RegisterItem.do")
	public String registerItem(ProductDto productDto, 
							  MultipartFile multipartProfile, 
							  HttpServletResponse response,
							  HttpServletRequest request
							  ) throws IOException {
		String context = request.getContextPath();//지금 실행중인 context
		String fileRoot =  "/home/ubuntu/uploadFiles/";
		String originalFileName =  multipartProfile.getOriginalFilename(); // 중복 파일때문에...
		String extention =  FilenameUtils.getExtension(originalFileName);// 확장자 구하기...
		String savedFileName = UUID.randomUUID()+"."+extention; //16짜리 random코드 작성
		File targetFile = new File(fileRoot+savedFileName); 
		String dbFileName = context+"/productImage/"+savedFileName;
		
			InputStream fileStream =multipartProfile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
			
			productDto.setProductRealImg(originalFileName);
			productDto.setProductImage(dbFileName);
			
			productDto.setProductHits(0);
			
		
		log.info("productDto ={}",productDto.toString());
		int result =productDao.insertProduct(productDto);
		if(result>0) {
			ScriptWriterUtil.alertAndNext(response, "등록되었습니다", "AdminPage.do");
		}else {
			ScriptWriterUtil.alertAndBack(response, "등록실패");
		}
		return null;
		
	}
	
}
