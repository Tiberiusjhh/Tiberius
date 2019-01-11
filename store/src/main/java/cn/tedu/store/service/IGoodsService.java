package cn.tedu.store.service;

import java.util.List;
import cn.tedu.store.entity.Goods;

/**
 * 商品数据的业务接口
 * @author Tiberius
 *
 */
public interface IGoodsService {

	/**
	 * 查询商品信息集合
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods> getgoodListShoops(Integer parentId,
			Integer offset,Integer count);
	
	/*
	 * 根据id查询商品详情
	 */
	public Goods findById(long id);
	
	
	/**
	 * 查询热销榜  显示数据量为动态
	 * @param count   显示条数
	 * @return
	 */
	List<Goods> findByPriority(Integer count);
}
