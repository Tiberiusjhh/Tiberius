package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.GoodsShoops;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsShoop {

	
	@Autowired
	private IGoodsShoopsService iGoodsShoopsService;
	
	
	@Test
	public void goodsShoop() {
		List<GoodsShoops> parenetIDListShoops = iGoodsShoopsService.getParenetIDListShoops(0);
		System.out.println(parenetIDListShoops);
	}
}
