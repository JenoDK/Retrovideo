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
import be.vdab.dao.ReservatieDAO;
import be.vdab.entities.Reservatie;

@WebServlet("/reservaties.htm")
public class ReservatiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/reservaties.jsp";
	private final transient ReservatieDAO reservatieDAO = new ReservatieDAO();
	private final transient FilmDAO filmDAO = new FilmDAO();

	@Resource(name = ReservatieDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		reservatieDAO.setDataSource(dataSource);
		filmDAO.setDataSource(dataSource);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Iterable<Reservatie> reservaties = reservatieDAO.findAll();
		request.setAttribute("reservaties", reservaties);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("verwijderknop") != null) {
			long klantid = Long.parseLong(request.getParameter("klantid"));
			long filmid = Long.parseLong(request.getParameter("filmid"));
			reservatieDAO.delete(klantid, filmid);
			filmDAO.changeGereserveerd("-1", filmid);
		}
		response.sendRedirect(response.encodeRedirectURL(request
				.getRequestURI()));
	}

}
