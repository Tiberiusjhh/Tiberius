package cn.tedu.store.mapper;
/**
 * 购物车的映射接口
 */
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;

public interface CartMapper {
	/**
	 * 查询购物车中是否有该商品
	 * @param uid
	 * @param goodsId
	 * @return
	 */
	Cart findByUidAndGid(@Param("uid") Integer uid,@Param("goodsId")Long goodsId);
	
	/**
	 * 添加收藏到购物车的数据
	 * @param cart
	 * @return
	 */
	Integer addnew(Cart cart);
	
	/**
	 * 如果购物车中有该商品那么对其数量进行更新
	 * @param id
	 * @param count
	 * @param modifiedUser   最后修改人
	 * @param modifiedTime   最后修改时间
	 * @return
	 */
	Integer updateCount(@Param("id")Integer id,@Param("count")Integer count
			,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);

}
