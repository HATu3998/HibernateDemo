package com.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Users;
import com.hibernate.utils.HibernateUtil;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public void destroy() {
        sessionFactory.close();
    }
	static final SessionFactory factory=HibernateUtil.getSessionFactory();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	 List<Users> userList = getUserList(); // Giả sử userList là danh sách các đối tượng Users
		 Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			Users u=new Users();
			//u.setId(1);
			String username=request.getParameter("username");
			String pass=request.getParameter("password");
			u.setUsername(username);
			u.setPassword(pass);
			session.save(u);
			tx.commit();
		    // Đặt thuộc tính "userList" vào request để truyền xuống JSP
		 //   request.setAttribute("userList", userList);

		    // Chuyển hướng (forward) đến JSP
		    RequestDispatcher dispatcher = request.getRequestDispatcher("UserServlet");
		    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
