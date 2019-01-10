package cn.tedu.store.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.exception.AccessDeniedException;
import cn.tedu.store.service.exception.AddressNotFoundException;
import cn.tedu.store.service.exception.InsertException;
import cn.tedu.store.service.exception.UpdateException;
import cn.tedu.store.service.exception.UserNotFoundException;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressMapper addressMapper;
	
	
	
	@Autowired
	private IDistrictService iDistrictService;
	
	@Override
	public Address create(String username,Address address) throws InsertException {
		Integer countByUid = getCountByUid(address.getUid());
		System.out.println("查询到用户的条数:"+countByUid);
		//用三眼表达来确定是否为默认地址
		address.setIsDefault(countByUid == 0 ? 1 : 0);
		
		// 根据address中的province、city、area的代号获取中文地址
		String province = address.getProvince().toString();
		String city  = address.getCity().toString();
		String area = address.getArea().toString();
		String district = getDistrict(province, city, area);
		address.setDistrict(district);
		
		//封装日志
		Date date = new Date();
		
		address.setName(username);
		address.setCreatedUser(username);
		address.setCreatedTime(date);
		address.setModifiedUser(username);
		address.setModifiedTime(date);
		
		//执行创建地址并返回内容
		addnew(address);
		
		return address;
	}
	
	@Override
	public List<Address> findByUidAddresses(Integer uid) throws UserNotFoundException {
		
		return findByUIDAddresss(uid);
	}
	
	
	
	/**
	 * 根据省、市、区的代号获取名称
	 * @param province   省的代号
	 * @param city    市的代号
	 * @param area    区的代号
	 * @return       省市区的中文名称，列如：浙江省杭州市上城区
	 */
	private String getDistrict(String province,String city,String area) {
		
		String provinceName = null;
		String cityName = null;
		String areaName = null;
		
		District gainProvince = iDistrictService.getByCode(province);
		District gainCity = iDistrictService.getByCode(city);
		District gainArea = iDistrictService.getByCode(area);
		
		/**gainProvince\gainCity\gainArea 进行空值判断
		 * 
		 */
		if (gainProvince !=null) {
			provinceName = gainProvince.getName();
		}
		
		
		if (gainProvince !=null) {
			cityName = gainCity.getName();
		}
		
		
		if (gainProvince !=null) {
			areaName = gainArea.getName();
		}
		
		
		return provinceName+" "+cityName+" "+areaName;
	}
	
	
	
	/**
	 * 根据id修改相关默认地址
	 * @Transactional  事务注解
	 */
	@Override
	@Transactional
	public void updateDefalutById(Integer uid,Integer id) {
		
		Address findById = findById(id);
		
		
		if (findById == null) {
			throw new AddressNotFoundException("设置默认收货地址失败，尝试访问的收货地址不存在");
		}
		
		if (findById.getUid() !=uid ) {
		
				throw new AccessDeniedException("设置默认收货地址失败，访问权限出错");
			
		}
		
		updateAddresByUid(uid);
		updateDefultAddresById(id);
	}

	
	

	/**
	 * 地址的增加
	 * @param address  地址类
	 */
	private void addnew(Address address) {
		Integer addnew = addressMapper.addnew(address);
		if (addnew != 1) {
			throw new InsertException("增加地址失败，发生未知错误！");
		}
	}
	
	/**
	 * 根据用户uid查询用户地址条数
	 * @param uid   用户id
	 * @return   返回用户地址条数
	 */
	private Integer getCountByUid(Integer uid) {
		return addressMapper.getCountByUid(uid);
	}
	
	
	/**
	 * 根据用户uid查询到用户的收货地址集合
	 * @param uid
	 * @return
	 */
	private List<Address> findByUIDAddresss(Integer uid){
		return addressMapper.findByUidAddresse(uid);
	}
	
	/**
	 * 删除的私有方法
	 * @param id
	 */
	private void addressDelete(Integer id) {
		Integer addressDeleteById = addressMapper.addressDeleteById(id);
		if (addressDeleteById == 0) {
			
		}
	}

	/**
	 * 将所有的地址修改为0
	 * @param uid
	 * @return
	 */
	private void updateAddresByUid(Integer uid) {
		Integer updateNonDefalutByUid = addressMapper.updateNonDefalutByUid(uid);
		if (updateNonDefalutByUid < 1) {
			throw new UpdateException("发生错误！更新发生未知错误！");
		}
	}
	
	
	/**
	 * 将选中的地址修改为1
	 * @param id
	 * @return
	 */
	private void updateDefultAddresById(Integer id) {
		Integer updateDefalutById = addressMapper.updateDefalutById(id);
		if (updateDefalutById != 1) {
			throw new UpdateException("发生错误！更新发生未知错误！");
		}
	}
	
	
	
	@Override
	public void addressDeleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	 private  Address findById(Integer id) {
		return addressMapper.findById(id);
	 }
	
	
	
	
	


}
