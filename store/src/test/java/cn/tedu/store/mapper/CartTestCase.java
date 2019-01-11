
package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestCase {

	@Autowired
	private CartMapper cartMapper;
	
	
	@Test
	public void selectAll() {
		Cart findByUidAndGid = cartMapper.findByUidAndGid(1, 10024L);
		System.out.println(findByUidAndGid);
	}
	
	
	@Test
	public void insetCar() {
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGid(10024l);
		cart.setPrice(5000L);
		cart.setCount(5);
		cart.setCreatedUser("admin");
		Date date  = new Date();
		cart.setCreatedTime(date);
		cart.setModifiedUser("admin");
		cart.setModifiedTime(date);
		Integer addnew = cartMapper.addnew(cart);
		System.out.println(addnew);
	}
	
	
	
	@Test
	public void updaCouunt() {
		String modifiedUser = "java";
		Date modifiedTime = new Date();
		Integer updateCount = cartMapper.updateCount(1, 10, modifiedUser, modifiedTime);
		System.out.println(updateCount);
	}
	
}
