package com.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernate.entity.Users;
import com.hibernate.utils.HibernateUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 @Override
	    public void init() throws ServletException {
	        sessionFactory = HibernateUtil.getSessionFactory();
	    }
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 try (Session session = sessionFactory.openSession()) {
    	        Query<Users> query = session.createQuery("from users", Users.class);
    	        List<Users> userList = query.list();

    	        request.setAttribute("userList", userList);
    	        request.getRequestDispatcher("/users.jsp").forward(request, response);
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
     }
    @Override
    public void destroy() {
        sessionFactory.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
