package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.GoodsShoops;

public interface IGoodsShoopsService {

/**
 * 根据parentId获取子类的商品	
 * @param parentId
 * @return
 */
	public List<GoodsShoops> getParenetIDListShoops(Integer parentId);
	
}
