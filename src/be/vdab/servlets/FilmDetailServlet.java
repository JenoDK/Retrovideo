package be.vdab.servlets;

import java.io.IOException;
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

@WebServlet("/detailFilm.htm")
public class FilmDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/filmdetail.jsp";
	private final transient FilmDAO filmDAO = new FilmDAO();
	
	@Resource(name = FilmDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		filmDAO.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Film film = filmDAO.read(Long.parseLong(request.getParameter("id")));
			HttpSession session = request.getSession(false);
			@SuppressWarnings("unchecked")
			Set<Long> filmIdsInMandje = (Set<Long>) session
					.getAttribute("mandje");
			if (film == null) {
				request.setAttribute("fout", "Film niet gevonden");
			} else {
				if (filmIdsInMandje != null) {
					if (filmIdsInMandje.contains(Long.parseLong(request.getParameter("id")))){
						request.setAttribute("fout" , "Deze film zit al in het mandje");
					}
				}
				request.setAttribute("film", film);
			}			
		} catch (NumberFormatException ex) {
			request.setAttribute("fout", "Nummer niet correct");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
