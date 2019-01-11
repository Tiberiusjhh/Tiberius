package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.tedu.store.entity.GoodsShoops;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsShoopsTestCase2 {

	@Autowired
	private GoodsShoopsMapper goodsShoopsMapper;
	
	
	@Test
	public void ListGoodsShoops() {
		List<GoodsShoops> listGoodsShoops = goodsShoopsMapper.getListGoodsShoops();
		System.out.println(listGoodsShoops.size());
	}
	
	@Test
	public void ListparentGoodsShoops() {
		Integer parentId = 0;
		List<GoodsShoops> parenetIDListShoops = goodsShoopsMapper.getParenetIDListShoops(parentId);
		for (GoodsShoops goodsShoops : parenetIDListShoops) {
			System.out.println(goodsShoops);
		}
		System.out.println(parenetIDListShoops.size());
	}
}
