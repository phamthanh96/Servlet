/**
 *Copyright(C) Luvina
 *UserDatabase.java, Oct 1, 2019, Pham Thanh
 */
package model.logic;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import model.entities.UserBean;
import util.Common;

/**
 * 
 * @author Pham Thanh
 *
 */
public class UserDatabase extends ConnectionDatabase {


	public UserDatabase() throws ClassNotFoundException, IOException {
		super();
	}
	private PreparedStatement preStatement ;
	Common common= new Common();
	/**
	 * Phương thức lấy tất cả user trong bảng user
	 * @return
	 * @throws SQLException
	 */
	public List<UserBean> getAllUser() throws SQLException{
		List<UserBean> list = new ArrayList<UserBean>();
		String sql = "Select * from userasdasd";
		ResultSet rs;
		try {
			openConnect();
			preStatement =connect.prepareStatement(sql);
			rs=preStatement.executeQuery();
			UserBean user;
			while (rs.next()) {
				user=new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getDate("birthday"));
				user.setBirthplace(rs.getString("birthplace"));
				list.add(user);
			}
		} catch (SQLException e) {
				throw new SQLException("========= " + common.getErrorMessage("ERROR_QUERY_SQL") + " =========");
		} finally {
			closeConnect();
		}	
		return list;
	}
}
