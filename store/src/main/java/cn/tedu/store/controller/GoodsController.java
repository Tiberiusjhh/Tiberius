package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.util.ResponseResult;
/**
 * 带有商品图片的控制器
 */

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController{

	
	@Autowired
	private IGoodsService iGoodsService;
	
	
	@GetMapping("/list/{parentID}")
	public ResponseResult<List<Goods>> Cateefdsfs(@PathVariable("parentID")Integer parentId){
		Integer offset = 0;
		Integer count =4;
		List<Goods> getgoodListShoops = iGoodsService.getgoodListShoops(parentId, offset, count);
		return new ResponseResult<List<Goods>>(SUCCESS,getgoodListShoops);
	}
	
	@GetMapping("/detalist/{id}")
	public ResponseResult<Goods> getById(@PathVariable("id")Long id){
		Goods findById = iGoodsService.findById(id);
		return new ResponseResult<Goods>(SUCCESS,findById);
	}
	
	
	@GetMapping("/priority")
	public ResponseResult<List<Goods>> getHotGoods(){
		Integer count = 4;
		List<Goods> findByPriority = iGoodsService.findByPriority(count);
		return new ResponseResult<List<Goods>>(SUCCESS,findByPriority);
	}
	
	
	
	
}
