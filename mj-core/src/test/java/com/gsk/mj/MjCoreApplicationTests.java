package com.gsk.mj;

import com.gsk.mj.repository.NoticeTableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MjCoreApplicationTests {

	@Autowired
	private NoticeTableRepository noticeTableRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void test1() {
		System.out.println(noticeTableRepository.findLast().getId());
	}

}
