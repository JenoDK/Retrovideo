package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.dao.FilmDAO;
import be.vdab.entities.Film;

@WebServlet("/mandje.htm")
public class MandjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";
	private final transient FilmDAO filmDAO = new FilmDAO();

	@Resource(name = FilmDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		filmDAO.setDataSource(dataSource);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (request.getCookies() == null) {
			request.setAttribute("fout", "Dit werkt enkel als cookies aanstaan");
			request.getRequestDispatcher(VIEW).forward(request, response);
			return;
		}
		if (session != null) {
			@SuppressWarnings("unchecked")
			Set<Long> mandje = (Set<Long>) session.getAttribute("mandje");
			if (mandje != null) {
				List<Film> filmsInMandje = new ArrayList<>();
				for (long id : mandje) {
					filmsInMandje.add(filmDAO.read(id));
				}
				request.setAttribute("filmsInMandje", filmsInMandje);
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("toevoegknop") != null) {

			if (request.getParameter("id") != null) {
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				Set<Long> filmIdsInMandje = (Set<Long>) session
						.getAttribute("mandje");
				if (filmIdsInMandje == null) {
					filmIdsInMandje = new LinkedHashSet<>();
				}
				filmIdsInMandje.add(Long.parseLong(request.getParameter("id")));
				session.setAttribute("mandje", filmIdsInMandje);
			}
		}
		if (request.getParameter("verwijderknop") != null) {
			if (request.getParameterValues("id") != null) {
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				Set<Long> filmIdsInMandje = (Set<Long>) session
						.getAttribute("mandje");
				for (String nummerAlsString : request.getParameterValues("id")) {
					long id = Long.parseLong(nummerAlsString);
					filmIdsInMandje.remove(id);
				}
				session.setAttribute("mandje", filmIdsInMandje);
			}
		}
		response.sendRedirect(response.encodeRedirectURL(request
				.getRequestURI()));
	}

}
