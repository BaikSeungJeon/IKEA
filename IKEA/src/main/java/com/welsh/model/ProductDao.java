package com.welsh.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class ProductDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public int insertProduct(ProductDto productDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertProduct", productDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	
	public List<ProductDto> getAllProduct(){
		List<ProductDto> galleryList =null;
		SqlSession sqlSession =sqlSessionFactory.openSession();
		galleryList =sqlSession.selectList("getAllProduct");
		sqlSession.close();
		return galleryList;
		
	}

}
