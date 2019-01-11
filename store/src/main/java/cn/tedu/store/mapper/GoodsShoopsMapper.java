package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.GoodsShoops;

/**
 * 商品的映射接口
 */



public interface GoodsShoopsMapper {

	/**
	 * 全部商品的查询
	 * @return  集合GoodsShoops
	 */
	List<GoodsShoops> getListGoodsShoops();
	
	
	/**
	 * 根据父级id查询商品
	 * @return
	 */
	List<GoodsShoops> getParenetIDListShoops(Integer parentId);
}
