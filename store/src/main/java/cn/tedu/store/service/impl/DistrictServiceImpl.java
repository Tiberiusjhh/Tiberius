package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService{

	@Autowired
	private DistrictMapper districtMapper;
	
	
	@Override
	public List<District> getListByParent(String parent) {
		return findByParent(parent);
	}
	
	
	@Override
	public District getByCode(String code) {
		return findByCode(code);
	}
	
	/**
	 *  私有方法获取全部省份
	 * @param parent
	 * @return
	 */
	private List<District> findByParent(String parent) {
		return districtMapper.findByParent(parent);
	}

	/**
	 * 私有方法   根据code获取相应的中文名字
	 * @param code
	 * @return
	 */
	private District findByCode(String code) {
		return districtMapper.findByCode(code);
	}



	
	
}
