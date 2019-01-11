package cn.tedu.store.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTestCase {

	
	@Autowired
	private IAddressService iAddressService;
	
	@Autowired
	private IUserservice IUserservice;
	
	
	@Test
	public void address() {
		Address address= new Address();
		Integer uid = 9;
		User user = IUserservice.infoFormId(uid);
		address.setUid(uid);
		address.setProvince(530000);
		address.setCity(530600);
		address.setArea(530629);
		address.setPhone(user.getPhone());
		address.setAddress(null);
		address.setTag(null);
		iAddressService.create("java", address);
		System.out.println("结束");
	}
	
	
	@Test
	public void AllAddress() {
		Integer uid = 9;
		List<Address> findByUidAddresses = iAddressService.findByUidAddresses(uid);
		for (Address address : findByUidAddresses) {
			System.out.println(address);
		}
	}
	
	
	@Test
	public void updateAddress() {
		Integer uid =9;
		Integer id = 1;
		String modifiedUser = "testUser";
		iAddressService.updateDefalutById(uid, id, modifiedUser);
		System.out.println("结束");
	}
	
	@Test
	public void delteAddress() {
		Integer uid =9;
		Integer id = 1;
		String modifiedUser = "testUser";
		iAddressService.addressDeleteById(uid, id, modifiedUser);
		System.out.println("结束");
	}
	
	
}
