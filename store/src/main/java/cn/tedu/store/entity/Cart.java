package cn.tedu.store.entity;
/**
 * 购物车的实体类
 * 
 * @author Tiberius
 *
 */
public class Cart extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2319146138333668284L;
	//购物车id
	Integer id;
	//用户id
	Integer uid;
	//商品id
	Long gid;
	//商品单价
	Long price;
	//加入购物车的商品数量
	Integer count;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", gid=" + gid + ", price=" + price + ", count=" + count + "]";
	}
	
	
}
