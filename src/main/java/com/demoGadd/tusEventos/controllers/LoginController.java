package com.demoGadd.tusEventos.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoGadd.tusEventos.model.dao.UsuarioDAO;
import com.demoGadd.tusEventos.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UsuarioDAO usuarioDao;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		usuarioDao = UsuarioDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}
	
	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");

		Usuario usuario = usuarioDao.existe(nombre, contrasena);
		
		if(usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			request.setAttribute("mensaje", "Bienvenido " + usuario.getNombre());
			
			response.sendRedirect("backoffice/index.jsp");
			
		}

	}


}
