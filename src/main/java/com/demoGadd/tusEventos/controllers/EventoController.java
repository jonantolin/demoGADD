package com.demoGadd.tusEventos.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoGadd.tusEventos.model.dao.EventoDAO;
import com.demoGadd.tusEventos.model.pojo.Evento;


/**
 * Servlet implementation class EventoController
 */
@WebServlet("/eventos")
public class EventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EventoDAO eventoDao;
	
	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_DETALLE = "detalle.jsp";
	private static final String VIEW_ENTRADA = "entrada.jsp";
	private static String VIEW = VIEW_INDEX;
	
	public static final String OP_LISTAR = "367cd";
	public static final String OP_DETALLE = "27sf";
	public static final String OP_COMPRAR = "287sj";
       

    public EventoController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		eventoDao = EventoDAO.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doProccess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}


	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String op = request.getParameter("op");
		
		if(op == null) {
			op = OP_LISTAR;
		}
		
		switch (op) {
		
		case OP_LISTAR:
			listar(request, response);
			break;
			
		case OP_DETALLE:
			detalle(request, response);
			break;
			
		case OP_COMPRAR:
			comprar(request, response);
			break;
			
		default: 
			listar(request, response);
			break;
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private void comprar(HttpServletRequest request, HttpServletResponse response) {

		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		int numEntradas = Integer.parseInt(request.getParameter("entradas"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(eventoDao.comprar(id, numEntradas)) {
			request.setAttribute("mensajeEntrada", "Compra realizada, disfruta");
			request.setAttribute("nombre", nombre);
			request.setAttribute("email", email);
			request.setAttribute("telefono", telefono);
			request.setAttribute("numEntradas", numEntradas);
			
			try {
				Evento evento = eventoDao.getById(id);
				request.setAttribute("evento", evento);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			VIEW = VIEW_ENTRADA;
		}
		
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		
		
		int id = 0;
		String sId = request.getParameter("id");
		
		if(sId != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		

		Evento evento = new Evento();
		try {
			evento = eventoDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("evento", evento);
		
		VIEW = VIEW_DETALLE;
		
		
		
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		
		ArrayList<Evento> listaEventos = new ArrayList<Evento>();
		
		try {
			listaEventos = eventoDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listaEventos", listaEventos);
		
		VIEW = VIEW_INDEX;
		
		
	}

}
