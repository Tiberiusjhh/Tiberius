package cn.tedu.store.entity;
/**
 * 收货地址类
 * @author Tiberius
 *
 */
public class Address extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3535029458090526026L;
	private Integer id;
	private Integer uid;
	private String name;
	private Integer province;
	private Integer city;
	private Integer area;
	private String district;
	private String zip;
	private String address;
	private String phone;
	private String tel;
	private String tag;
	private Integer isDefault;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", name=" + name + ", province=" + province + ", city=" + city
				+ ", area=" + area + ", district=" + district + ", zip=" + zip + ", address=" + address + ", phone="
				+ phone + ", tel=" + tel + ", tag=" + tag + ", isDefault=" + isDefault + "]";
	}

	
	
	
}
