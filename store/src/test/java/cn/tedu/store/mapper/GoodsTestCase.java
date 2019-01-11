package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Goods;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTestCase {

	@Autowired
	private GoodsMapper goodsMapper;
	
	
	@Test
	public void ListGoods() {
		List<Goods> listGoods = goodsMapper.getListGoods();
		System.out.println(listGoods.size());
	}
	
	
	@Test
	public void ListGoodssssssss() {
		List<Goods> listGoods = goodsMapper.getgoodListShoops(34, 0, 1);
		System.out.println(listGoods.size());
	}
	
	@Test
	public void ListId() {
		Goods listGoods = goodsMapper.findById(10000005);
		System.out.println(listGoods);
	}
	
	/**
	 * 热销
	 */
	@Test
	public void findBy() {
		Integer count = 5;
		List<Goods> findByPriority = goodsMapper.findByPriority(count);
		for (Goods goods : findByPriority) {
			
			System.out.println(goods);
		}
	}
	
	
	
	
}
