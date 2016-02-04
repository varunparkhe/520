package homework1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework1.model.GradAdmiBean;

/**
 * Servlet implementation class AddNewApplication
 */
@WebServlet("/AddNewApplication")
public class AddNewApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewApplication() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/AddNewApplicationView.jsp").forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GradAdmiBean> entries = (List<GradAdmiBean>) getServletContext().getAttribute("entries");
		List<String> statuslst = (List<String>) getServletContext().getAttribute("statuslst");
		Double doublegpa = null;
		Date ddate = null;
		Boolean bool = false;

		String applicant = request.getParameter("applicant");

		String dates = request.getParameter("date");

		String gpas = request.getParameter("gpa");

		if (gpas.equals("")) {
			bool = true;
		} else {
			doublegpa = Double.parseDouble(gpas);
		}

		int status = Integer.parseInt(request.getParameter("stats"));

		if (applicant.isEmpty() || dates.isEmpty()) {
			response.sendRedirect("AddNewApplication");

		} else {

			SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
			try {
				ddate = formatter.parse(dates);
				// date = formatter.format(idate);
			} catch (ParseException e) {
				response.sendRedirect("AddNewApplication");
				// e.printStackTrace();
			}

			if (bool == true) {
				entries.add(new GradAdmiBean(applicant, ddate, null, statuslst.get(status)));
			} else {

				entries.add(new GradAdmiBean(applicant, ddate, doublegpa, statuslst.get(status)));
			}
			Collections.sort(entries, new Comparator<GradAdmiBean>() {

				@Override
				public int compare(GradAdmiBean o1, GradAdmiBean o2) {

					return o2.getDate().compareTo(o1.getDate());
				}
			});

			response.sendRedirect("CsGradAdmiMain");
		}
	}

}
