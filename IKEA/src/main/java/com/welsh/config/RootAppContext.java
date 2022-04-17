package com.welsh.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//프로젝트에 사용할 bean 정의
@Configuration
@ComponentScan("com.welsh.model")
public class RootAppContext {

	
		@Autowired
		private ApplicationContext applicationContext;
		
		@Bean
		public DataSource dataSource() {
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			hikariConfig.setJdbcUrl("jdbc:oracle:thin:@3.37.12.102:1521:xe");
			hikariConfig.setUsername("welsh");
			hikariConfig.setPassword("welsh");
			
			// 세부설정
			hikariConfig.setMaximumPoolSize(10);
			hikariConfig.setConnectionTimeout(50000); // 30초
			//hikariConfig.setLeakDetectionThreshold(300000);
			
			HikariDataSource dataSource = new HikariDataSource(hikariConfig);
			return dataSource;
		}
		
		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			sqlSessionFactoryBean.setConfigLocation( resolver.getResource("classpath:com/welsh/mybatis/config.xml"));
			//sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/jjang051/mybatis/mapper/*.xml"));
			sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/welsh/mybatis/mapper/*.xml"));

		
			
			
			//sqlSessionFactoryBean.setMapperLocations(resolver.getResource("classpath:com/jjang051/mybatis/ReplyBoardMapper.xml"));
		
			return sqlSessionFactoryBean.getObject();
		}
}
