package com.test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.demo.mybaits.service.ProductTableService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ProductTableService  productTableService;
	
	@Test
	public void contextLoads() {
		////////
		productTableService.ProduceBean();
	}

}
