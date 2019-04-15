package com.example.Meikkipussi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Meikkipussi.web.MeikkiController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeikkipussiApplicationTests {
	
	@Autowired
	MeikkiController controller;

	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
