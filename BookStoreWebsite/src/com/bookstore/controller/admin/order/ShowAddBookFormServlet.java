package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;


@WebServlet("/admin/show_add_form")
public class ShowAddBookFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAddBookFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BookDAO bookDAO =new BookDAO();
		List<Book> listBook = bookDAO.listAll();
		request.setAttribute("listBook", listBook);
		
		String addFormPage = "add_book_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(addFormPage);
		dispatcher.forward(request, response);
	}

}
