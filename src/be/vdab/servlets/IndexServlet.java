package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.dao.FilmDAO;
import be.vdab.dao.GenreDAO;
import be.vdab.entities.Film;
import be.vdab.entities.Genre;

@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final transient GenreDAO genreDAO = new GenreDAO();
	private final transient FilmDAO filmDAO = new FilmDAO();
	
	@Resource(name = GenreDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		genreDAO.setDataSource(dataSource);
		filmDAO.setDataSource(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Genre> genres = genreDAO.findAll();
		request.setAttribute("genres", genres);
		if (request.getParameter("genreid") != null){
			try {
				Iterable<Film> films = filmDAO.findAllByGenre(Long.parseLong(request.getParameter("genreid")));
				if (films == null) {
					request.setAttribute("fout", "Films niet gevonden");
				} else {
					request.setAttribute("films", films);
				}			
			} catch (NumberFormatException ex) {
				request.setAttribute("fout", "Nummer niet correct");
			}
		}
		request.setAttribute("activeGenre", request.getParameter("genreid"));
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
