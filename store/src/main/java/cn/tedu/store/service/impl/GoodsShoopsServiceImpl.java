package cn.tedu.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tedu.store.entity.GoodsShoops;
import cn.tedu.store.mapper.GoodsShoopsMapper;
import cn.tedu.store.service.IGoodsShoopsService;

@Service
public class GoodsShoopsServiceImpl implements IGoodsShoopsService{

	
	@Autowired
	private GoodsShoopsMapper goodsShoopsMapper;
	
	
	@Override
	public List<GoodsShoops> getParenetIDListShoops(Integer parentId) {
		return getParenetIDList(parentId);
	}
	
	
	
    private	List<GoodsShoops> getParenetIDList(Integer parentId){
    	return goodsShoopsMapper.getParenetIDListShoops(parentId);
    }



}
