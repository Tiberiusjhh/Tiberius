package cn.tedu.store.mapper;
/**
 * 地址的映射接口
 */
import java.util.List;

import cn.tedu.store.entity.District;

public interface DistrictMapper {

	/**
	 * 根据父类编号查询全部的名字集合
	 * @param parent
	 * @return   district集合
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 根据code查询中文名字
	 * @param code
	 * @return   返回district
	 */
	District findByCode(String code);
}
