package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	
	/**
	 * 获取商品列表
	 */
	@Override
	public List<Goods> getgoodListShoops(Integer parentId, Integer offset, Integer count) {
		
		return getListShoops( parentId, offset, count);
	}
	/**
	 * 根据id获取商品详情
	 */
	@Override
	public Goods findById(long id) {
		return getById(id);
	}
	
	
	
	@Override
	public List<Goods> findByPriority(Integer count) {
		return getByPriority(count);
	}

	
	private List<Goods> getListShoops(Integer parentId,
			Integer offset,Integer count){
		return goodsMapper.getgoodListShoops(parentId, offset, count);
	}
	
	
	private Goods getById(long id) {
		return goodsMapper.findById(id);
	}
	
	
	
	private List<Goods> getByPriority(Integer count){
		return goodsMapper.findByPriority(count);
	}
	
	
}
