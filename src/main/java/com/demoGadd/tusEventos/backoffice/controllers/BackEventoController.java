package com.demoGadd.tusEventos.backoffice.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
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

@WebServlet("/backoffice/eventos")
public class BackEventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EventoDAO eventoDao;

	private static final String VIEW_INDEX = "eventos/listado.jsp";
	private static final String VIEW_FORM = "eventos/formulario.jsp";
	private static String VIEW = VIEW_INDEX;

	public static final String OP_LISTAR = "367cd";
	public static final String OP_EDITAR = "263d";
	public static final String OP_GUARDAR = "232z";
	public static final String OP_NUEVO = "12z";
	public static final String OP_ELIMINAR = "155z";

	public BackEventoController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		eventoDao = EventoDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");

		if (op == null) {
			op = OP_LISTAR;
		}

		switch (op) {

		case OP_LISTAR:
			listar(request, response);
			break;

		case OP_EDITAR:
			editar(request, response);
			break;

		case OP_GUARDAR:
			guardar(request, response);
			break;
		
		case OP_NUEVO:
			nuevo(request, response);
			break;
		
		case OP_ELIMINAR:
			eliminar(request, response);
			break;

		default:
			listar(request, response);
			break;
		}

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		if(eventoDao.delete(id)) {
			request.setAttribute("mensaje", "Evento eliminado");
		}else {
			request.setAttribute("mensaje", "No fue posible eliminar el evento");
		}
		
		listar(request, response);
		
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		Evento evento = new Evento();
		request.setAttribute("evento", evento);
		VIEW = VIEW_FORM;
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String lugar = request.getParameter("lugar");
		Date fecha = Date.valueOf(request.getParameter("fecha"));

		Double precio = Double.valueOf(request.getParameter("precio"));

		int vendidas = Integer.parseInt(request.getParameter("vendidas"));

		int aforo = Integer.parseInt(request.getParameter("aforo"));
		int disponibles = aforo - vendidas;
		String portadaImg = request.getParameter("portadaImg");

		Evento evento = new Evento(id, nombre, lugar, fecha, precio, disponibles, vendidas, aforo, portadaImg);
		Boolean modificado = false;

		try {

			if (evento.getId() == -1) {
				evento = eventoDao.create(evento);
			} else {
				modificado = eventoDao.update(evento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(modificado) {
			request.setAttribute("evento", evento);
			request.setAttribute("mensaje", "Evento modificado con éxito");
		}else {
			request.setAttribute("evento", evento);
			request.setAttribute("mensaje", "Evento creado con éxito");
		}
		
		

	}
	

	private void editar(HttpServletRequest request, HttpServletResponse response){

		int id = 0;
		String sId = request.getParameter("id");

		if (sId != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		Evento evento = new Evento();
		try {
			evento = eventoDao.getById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("evento", evento);

		VIEW = VIEW_FORM;

	}

	private void listar(HttpServletRequest request, HttpServletResponse response){

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
