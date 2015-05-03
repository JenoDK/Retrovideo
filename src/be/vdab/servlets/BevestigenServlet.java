package be.vdab.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
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
import be.vdab.dao.KlantDAO;
import be.vdab.dao.ReservatieDAO;
import be.vdab.entities.Film;
import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;

@WebServlet("/bevestigen.htm")
public class BevestigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/bevestigen.jsp";
	private static final String SUCCES_VIEW = "/WEB-INF/JSP/rapport.jsp";
	private final transient KlantDAO klantDAO = new KlantDAO();
	private final transient FilmDAO filmDAO = new FilmDAO();
	private final transient ReservatieDAO reservatieDAO = new ReservatieDAO();

	@Resource(name = KlantDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantDAO.setDataSource(dataSource);
		filmDAO.setDataSource(dataSource);
		reservatieDAO.setDataSource(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			@SuppressWarnings("unchecked")
			Set<Long> mandje = (Set<Long>) session.getAttribute("mandje");
			if (mandje != null) {
				List<Film> filmsInMandje = new ArrayList<>();
				for (long id : mandje) {
					filmsInMandje.add(filmDAO.read(id));
				}
				request.setAttribute("filmsInMandje", filmsInMandje);
				request.setAttribute("aantalFilmsInMandje", filmsInMandje.size());
			}
		}
		Klant klant = klantDAO.read(Long.parseLong(request.getParameter("id")));
		request.setAttribute("klantnaam" , klant.getNaam());
		request.setAttribute("klantid" , klant.getId());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("bevestigknop") != null) {
			HttpSession session = request.getSession();
			if (session != null) {
				@SuppressWarnings("unchecked")
				Set<Long> mandje = (Set<Long>) session.getAttribute("mandje");
				long klantid = Long.parseLong(request.getParameter("id"));
				if (mandje != null) {
					List<Film> filmsFout = new ArrayList<>();
					for (long id : mandje) {
						Film film = filmDAO.read(id);
						if (film.getVoorraad()>film.getGereserveerd()){
							filmDAO.changeGereserveerd("+1", id);
							java.util.Date date = new Date();						
							Reservatie reservatie = new Reservatie(klantid, id, date);
							reservatieDAO.create(reservatie);
						}else {
							filmsFout.add(film);
						}
					}
					if (! filmsFout.isEmpty()){
						request.setAttribute("foutefilms", filmsFout);
					}else {
						request.setAttribute("foutefilms", null);
					}
					session.removeAttribute("mandje");
				}
			}
		}
		request.getRequestDispatcher(SUCCES_VIEW).forward(request, response);
		
	}

}
