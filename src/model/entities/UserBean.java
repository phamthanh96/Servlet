/**
 *Copyright(C) Luvina
 *UserBean.java, Oct 1, 2019, Pham Thanh
 */
package model.entities;

import java.util.Date;

/**
 * @author Pham Thanh
 *
 */
public class UserBean {
	private int id;
	private String name;
	private Date birthday;
	private String birthplace;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
}
