package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictTestCase {

	@Autowired
	private IDistrictService iDistrictService;

	@Test
	public void findpa() {
		String parent = "86";
		List<District> findByParent = iDistrictService.getListByParent(parent);
		for (District district : findByParent) {
			System.out.println(district);
		}
	}

	@Test
	public void findCode() {
		String code = "110107";
		District findByCode = iDistrictService.getByCode(code);
		System.out.println(findByCode);
	}

}
