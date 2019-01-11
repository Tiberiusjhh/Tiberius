package cn.tedu.store.entity;
/**
 * 对应的商品的实体类  无图片
 * @author Tiberius
 *
 */
public class GoodsShoops extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8842101390599839654L;

	private Integer id;
	private Integer parentId;
	private String name;
	private Integer status;
	private Integer sortOrder;
	private Integer isParent;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	@Override
	public String toString() {
		return "GoodsShoops [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrder=" + sortOrder + ", isParent=" + isParent + "]";
	}
	
	
	
	
	
}
