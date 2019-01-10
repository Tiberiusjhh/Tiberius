package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.District;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/district")
public class DistrictrControoler extends BaseController{

	@Autowired
	private IDistrictService iDistrictService;
	
	
	@RequestMapping("/list/{parent}")
	public ResponseResult<List<District>> getListByParent(@PathVariable("parent")String parent){
		List<District> listByParent = iDistrictService.getListByParent(parent);
		return new ResponseResult<List<District>>(SUCCESS,listByParent);
	}
}
