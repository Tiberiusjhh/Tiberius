package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.exception.DeleteException;
import cn.tedu.store.service.exception.InsertException;
import cn.tedu.store.service.exception.UpdateException;
import cn.tedu.store.service.exception.UserNotFoundException;

/**
 * 地址的持久层接口
 * @author Tiberius
 *
 */
public interface IAddressService {
	
	/**
	 * 地址增加的抽象方法
	 * @param address  地址类
	 * @return   返回一个地址类
	 * @throws InsertException    插入失败异常
	 */
   public  Address  create (String username,Address address) throws InsertException;
   
 
   /**
    * 用户收货地址管理
    * @param uid   用户id
    * @return    返回address的list集合
    * @throws UserNotFoundException   该用户没有找到
    */
   public List<Address> findByUidAddresses(Integer uid) ;
   
   
   
   /**
    * 
    * 根据uid更改默认地址的属性全部为0
    * @param uid    用户的uid
    * @return   返回受到影响的行数大于0
    *//*
   public Integer updateNonDefalutByUid(Integer uid);
   */
   
   /**
    * 根据id更改默认地址的属性为1
    * @param id   id
    * @return    等于1
    */
   public void updateDefalutById(Integer uid,Integer id,String modifiedUser) throws UpdateException;
   
   

   /**
    * 根据id删除 收货地址信息
    * @param uid    收货地址的归属用户id
    * @param id      收货地主id
    * @param modifiedUser   修改用户
    * @throws DeleteException    删除异常的类
    */
   public void addressDeleteById(Integer uid,Integer id,String modifiedUser) throws DeleteException;
   
   
   
}
