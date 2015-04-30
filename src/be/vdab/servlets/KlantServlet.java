package be.vdab.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.dao.KlantDAO;
import be.vdab.entities.Klant;

@WebServlet("/klant.htm")
public class KlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/klant.jsp";
	private final transient KlantDAO klantDAO = new KlantDAO();

	@Resource(name = KlantDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantDAO.setDataSource(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null) {
			String familienaam = request.getParameter("familienaam");
			List<Klant> klanten = (List<Klant>) klantDAO.findAllByString(familienaam);
			if (familienaam.isEmpty()) {
				request.setAttribute("fout", "Tik minstens één letter");
			} else {
				if (klanten.size() == 0) {
					request.setAttribute("fout",
							"Geen klanten gevonden");
				} else {
					request.setAttribute("klanten", klanten);
				}
			}
		}		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}


}
