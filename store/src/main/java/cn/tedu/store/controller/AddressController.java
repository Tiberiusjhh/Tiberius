package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.util.ResponseResult;

/**
 * 用户地址的增加控制器
 * @author Tiberius
 *
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{

	@Autowired
	private IAddressService iAddressService;
	
	
	/**
	 * 地址增加
	 * @param session
	 * @param address
	 * @return
	 */
	@PostMapping("/create")
	public ResponseResult<Void> addressNew(HttpSession session,Address address) {
		//获取用户名
		String username  =  session.getAttribute("username").toString();
		//获取用户uid
		Integer uid = getUidFromSession(session);
		//将uid放入address
		address.setUid(uid);
		
		iAddressService.create(username, address);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	/**
	 * 地址列表展示
	 * @param session
	 * @return
	 */
	@PostMapping("/list")
	public ResponseResult<List<Address>> findAll(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<Address> findByUidAddresses = iAddressService.findByUidAddresses(uid);
		return new ResponseResult<List<Address>>(SUCCESS,findByUidAddresses);
	}
	
	/**
	 * 地址删除
	 * @param session
	 * @return
	 */
	@PostMapping("/addressDelete")
	public ResponseResult<Void> addressDeleteById(HttpSession session){
		
		System.out.println(session.getId());
		return new ResponseResult<Void>(SUCCESS);
	}
	
	
	
	
	
	@GetMapping("/addressDefault/{id}")
	public ResponseResult<Void> setAddressDefault(HttpSession session,@PathVariable("id")Integer id){
		Integer uid = getUidFromSession(session);
		iAddressService.updateDefalutById(uid, id);
		
		System.out.println("处理地址"+id);
		return new ResponseResult<Void>(SUCCESS);
	}
	
}
