package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Address;

/**
 * 地址映射接口
 * 
 * @author Tiberius
 *
 */
public interface AddressMapper {

	/**
	 * 插入地址
	 * 
	 * @param address 地址类
	 * @return 返回影响的行数
	 */
	public Integer addnew(Address address);

	/**
	 * 根据用户uid统计条数
	 * 
	 * @param uid 用户uid
	 * @return
	 */
	public Integer getCountByUid(Integer uid);

	
	/**
	 * 根据用户id查询地址
	 * 
	 * @param uid 用户id
	 * @return 地址信息类
	 */
	public List<Address> findByUidAddresse(Integer uid);
	
	
	/**
	 * 根据id对表格的数据进行删除
	 * @param id  用户id
	 * @return   返回影响行数
	 */
	public Integer addressDeleteById(Integer id);
	
	
	
	
	 /**
	    * 
	    * 根据uid更改默认地址的属性全部为0
	    * @param uid    用户的uid
	    * @return   返回受到影响的行数大于0
	    */
	   public Integer updateNonDefalutByUid(Integer uid);
	   
	   
	   /**
	    * 根据id更改默认地址的属性为1
	    * @param id   id
	    * @return    等于1
	    */
	   public Integer updateDefalutById(Integer id);
	   
	   //根据id查地址
	   public  Address findById(Integer id);
	   
	   
	   //查询第一条
	   public  Address findLastmodified(Integer uid);
}
