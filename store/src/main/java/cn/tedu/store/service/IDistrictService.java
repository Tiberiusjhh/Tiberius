package cn.tedu.store.service;


import java.util.List;
/**
 * 省、市、区的业务持久层
 */
import cn.tedu.store.entity.District;

public interface IDistrictService {
	
	/**
	 * 查询所有的市
	 * @param parent  市的parent为86
	 * @return    返回集合
	 */
	public List<District> getListByParent(String parent);
	
	/**
	 * 根据code查具体的城市名字
	 * @param code  
	 * @return  
	 */
	public District getByCode(String code);
}
