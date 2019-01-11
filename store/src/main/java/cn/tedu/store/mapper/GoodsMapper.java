package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Goods;

/**
 * 地址的映射接口
 */


public interface GoodsMapper {

	/**
	 * 查询goods表的内容
	 * @return  返回goods的集合
	 */
	public List<Goods> getListGoods();
	
	
	
	/**
	 * 
	 * @param categoryId
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods> getgoodListShoops(@Param("categoryId")Integer parentId,
			@Param("offset")Integer offset,@Param("count")Integer count);
	
	
	/**
	 * 根据商品id返回商品信息
	 * @param id
	 * @return
	 */
	public Goods findById(long id);
	
	
	/**
	 * 热销榜数据查询
	 * @param count   显示的条数进行灵活处理
	 * @return        热销的商品集合
	 */
	List<Goods> findByPriority(Integer count);
	
}
