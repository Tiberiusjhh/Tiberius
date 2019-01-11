package cn.tedu.store.controller;
/**
 * 没有商品图片的控制器
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.GoodsShoops;
import cn.tedu.store.service.IGoodsShoopsService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/category")
public class GoodCategoryController extends BaseController{

	@Autowired
	private IGoodsShoopsService iGoodsShoopsService;
	
	@GetMapping("/shoplist")
	public ResponseResult<List<GoodsShoops>> goodsShoopsList(Integer parentId){
		List<GoodsShoops> parenetIDListShoops = iGoodsShoopsService.getParenetIDListShoops(parentId);

		return new ResponseResult<List<GoodsShoops>>(SUCCESS,parenetIDListShoops);
	}
}
