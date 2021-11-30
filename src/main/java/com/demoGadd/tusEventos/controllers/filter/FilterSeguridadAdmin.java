package com.demoGadd.tusEventos.controllers.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoGadd.tusEventos.model.pojo.Usuario;

/**
 * Servlet Filter implementation class FilterSeguridadAdmin
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/backoffice/*" })
public class FilterSeguridadAdmin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterSeguridadAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;

			HttpSession session = req.getSession();

			session.setAttribute("callback", req.getRequestURI());

			if (session.getAttribute("usuario") != null) {

				Usuario usuario = (Usuario) session.getAttribute("usuario");

				if ("admin".equals(usuario.getNombre())) {

					chain.doFilter(request, response);

				} else {

					session.setAttribute("mensaje",
							"Usuario no autorizado, ingresa como administrador");
					res.sendRedirect(req.getContextPath() + "/login.jsp");
				}

			} else {
				
				session.setAttribute("mensaje", "Inicia sesión para acceder");
				res.sendRedirect(req.getContextPath() + "/login.jsp");
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
