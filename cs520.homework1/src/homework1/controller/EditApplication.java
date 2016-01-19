package homework1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework1.model.GradAdmiBean;

/**
 * Servlet implementation class EditApplication
 */
@WebServlet("/EditApplication")
public class EditApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditApplication() {
		super();

	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GradAdmiBean> entries = (List<GradAdmiBean>) getServletContext().getAttribute("entries");
		List<String> statuslst = (List<String>) getServletContext().getAttribute("statuslst");

		int index = Integer.parseInt(request.getParameter("index"));

		request.setAttribute("entry", entries.get(index));


		request.getRequestDispatcher("/WEB-INF/EditApplicationView.jsp").forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GradAdmiBean> entries = (List<GradAdmiBean>) getServletContext().getAttribute("entries");
		List<String> statuslst = (List<String>) getServletContext().getAttribute("statuslst");
		Date ddate = null;
		Boolean bool = false;
		Double dgpa = null;
		int index = Integer.parseInt(request.getParameter("index"));

		GradAdmiBean entry = entries.get(index);
		String dates = request.getParameter("date");

		String check = request.getParameter("gpa");
		if (check.equals("")) {
			bool = true;
		} else {
			dgpa = Double.parseDouble(check);
		}

		Boolean send = false;
		SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
		try {
			ddate = formatter.parse(dates);
			// date = formatter.format(idate);
		} catch (ParseException e) {
			response.sendRedirect("EditApplication");
			e.printStackTrace();
			send = true;
		}

		entry.setApplicant(request.getParameter("applicant"));
		entry.setDate(ddate);
		if (bool == true) {
			entry.setGpa(null);
		} else {
			entry.setGpa(dgpa);
		}
		int newstatus = Integer.parseInt(request.getParameter("stats"));
		entry.setStatus(statuslst.get(newstatus));

		if (send != true) {
			response.sendRedirect("CsGradAdmiMain");
		}
	}

}
