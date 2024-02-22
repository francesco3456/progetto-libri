package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.UtenteBean;

import service.UtenteService;

@WebServlet ("/Giovani")

public class Giovani extends HttpServlet{

    private static final long serialVersionUID = 2L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UtenteService utenteService = new UtenteService();

        List<UtenteBean> utentiGiovani = utenteService.utentiGiovani();
        for (UtenteBean ut : utentiGiovani) {
            System.out.println(ut+"ciao");
        }

        request.setAttribute("risultato", utentiGiovani);
        
        System.out.println();

        RequestDispatcher rd = request.getRequestDispatcher("/giovani.jsp");
        rd.forward(request, response);
    }
     }
