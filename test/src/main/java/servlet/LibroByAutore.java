package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.LibroBean;
import service.LibroService;

@WebServlet("/LibroByAutore")
public class LibroByAutore extends HttpServlet{
	
	private static final long serialVersionUID = 4L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String autore = request.getParameter("autore");
    	
    	LibroService libroService = new LibroService();
    	List<LibroBean> listaLibri = libroService.visualizzaLibriByAutore(autore);
    	
        for (LibroBean li : listaLibri) {
            System.out.println(li);
        }
        
	    request.setAttribute("libri", listaLibri);

	    // Inoltra la richiesta alla pagina JSP per visualizzare i libri
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/libriByAuthor.jsp");
	    dispatcher.forward(request, response);
    	
    	
    }

}
