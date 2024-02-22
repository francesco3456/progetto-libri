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


@WebServlet ("/SelezioneLibri")
public class SelezioneLibri extends HttpServlet {
	
    private static final long serialVersionUID = 3L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LibroService libroService = new LibroService();

        List<LibroBean> autori = libroService.visualizzaAutori();
        for (LibroBean li : autori) {
            System.out.println(li);
        }

        request.setAttribute("autori", autori);
        
        System.out.println();

        RequestDispatcher rd = request.getRequestDispatcher("/selezioneLibri.jsp");
        rd.forward(request, response);
    }
}
