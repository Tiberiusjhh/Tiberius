package cn.tedu.store.mapper;

import java.util.Date;
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
public class AddressTest {

	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void finByUid() {
		Integer countByUid = addressMapper.getCountByUid(2);
		System.out.println(countByUid);
	}
	
	@Test
	public void addAddress() {
		Integer uid = 9;
		User selectFromId = userMapper.selectFromId(uid);
		Address address = new Address();
		address.setUid(uid);
		address.setName(selectFromId.getUsername());
		address.setProvince(110000);
		address.setCity(110100);
		address.setArea(110106);
		address.setDistrict("北京市 市辖区 丰台区");
		address.setPhone(selectFromId.getPhone());
		if (addressMapper.getCountByUid(uid) == 0) {
			address.setIsDefault(1);			
		} else {
			address.setIsDefault(0);
		}
		Date date = new Date();
		address.setAddress(null);
		address.setTag(null);
		address.setModifiedTime(date);
		address.setModifiedUser(selectFromId.getUsername());
		address.setCreatedTime(date);
		address.setCreatedUser(selectFromId.getUsername());
		Integer addnew = addressMapper.addnew(address);
		System.out.println(addnew);
	}
	
	
	@Test
	public void finUidAddress() {
		Integer uid = 9;
		List<Address> findByUidAddresse = addressMapper.findByUidAddresse(uid);
		for (Address address : findByUidAddresse) {
			System.out.println(address);
		}
	}
	
	
	@Test
	public void addressDele() {
		Integer id = 78;
		Integer addressDeleteById = addressMapper.addressDeleteById(id);
		System.out.println(addressDeleteById);
	}
	
	
	@Test
	public void updauid() {
		Integer updateNonDefalutByUid = addressMapper.updateNonDefalutByUid(9);
		System.out.println(updateNonDefalutByUid);
	}
	
	
	@Test
	public void updabyid() {
		Integer id = 2;
		String modifiedUser ="testUser";
		Date  modifiedTime = new Date();
		Integer updateDefalutById = addressMapper.updateDefalutById(id, modifiedUser, modifiedTime);
		System.out.println(updateDefalutById);
	}
	
	@Test
	public void fiddddbyid() {
		Integer id = 3;
		Address findById = addressMapper.findById(id);
		System.out.println(findById);
	}
	
	
	
	@Test
	public void fidList() {
		Integer uid = 9;
		Address findById = addressMapper.findLastmodified(uid);
		System.out.println(findById);
	}
}
