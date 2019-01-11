package cn.tedu.store.service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.exception.InsertException;
import cn.tedu.store.service.exception.UpdateException;

/**
 * 购物车的持久层接口
 * @author Tiberius
 *
 */
public interface ICartService {

	/**
	 * 购物车的添加
	 * @param cart   购物车的实体类
	 * @throws InsertException   数据插入异常
	 * @throws UpdateException   数据更新异常
	 */
	public void addToCart(Cart cart) throws InsertException,UpdateException;
}
