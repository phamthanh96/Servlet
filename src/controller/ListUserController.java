/**
 *Copyright(C) Luvina
 *ListUserController .java, Oct 1, 2019, PhamThanh
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.UserBean;
import model.logic.*;
import util.Common;

/**
 * 
 * @author Pham Thanh
 *
 */
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserController() {
        super();
    }

	/**
	 * Phương thức xử lý khi url /listUser được gọi
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextRoot = request.getContextPath();
		try {
			UserDatabase userDatabase= new UserDatabase();
			List<UserBean> list= userDatabase.getAllUser();
			List<UserBean> listUserJava=encodeListUser(userDatabase.getAllUser());
			
			request.setAttribute("users",list);
			request.setAttribute("userJava",listUserJava);
			
			RequestDispatcher rd=request.getRequestDispatcher("listUser.jsp");  
	        rd.forward(request, response);

		} catch (Exception e) {
			String errorMessage = "He Thong bi loi";
			response.sendRedirect(contextRoot + "/error?loi=" + errorMessage);
			System.err.println(e.getMessage());
		}		
	}
	/**
	 * Phương thức xử lí encode cho listUser
	 * @param listUser listUser chưa được encode
	 * @return
	 */
	public List<UserBean> encodeListUser(List<UserBean> listUser) {
		List<UserBean> list = new ArrayList<UserBean>();
		Common common= new Common();
		for (UserBean user : listUser) {
			UserBean userbean= new UserBean();
			userbean.setId(user.getId());
			userbean.setName(common.encodeHtml(user.getName()));
			userbean.setBirthday(user.getBirthday());
			userbean.setBirthplace(common.encodeHtml(user.getBirthplace()));
			list.add(userbean);
		}
		return list;
	}
}
