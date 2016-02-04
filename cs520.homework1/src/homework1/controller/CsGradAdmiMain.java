package homework1.controller;

import homework1.model.GradAdmiBean;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsGradAdmiMain This is the Main Page and First
 * Page of the Application and gets loaded first.
 * 
 */
@WebServlet(urlPatterns = "/CsGradAdmiMain", loadOnStartup = 0)
public class CsGradAdmiMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CsGradAdmiMain() {
	}

	@SuppressWarnings("deprecation")
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		// Main List to hold the Display
		List<GradAdmiBean> entries = new ArrayList<GradAdmiBean>();

		// List to hold Drop-Down list of Status
		List<String> statuslst = new ArrayList<String>();

		statuslst.add("Application Incomplete");
		statuslst.add("Pending Review");
		statuslst.add("Rejected");
		statuslst.add("Accepted");
		statuslst.add("Admission Offer Sent");
		statuslst.add("Admission Offer Accepted");

		Date date1 = new Date("10/21/2015");
		Date date2 = new Date("3/20/2015");
		Date date3 = new Date("3/1/2015");

		entries.add(new GradAdmiBean("John Doe", new Date(date1.toString()), 3.1, "Pending Review"));
		entries.add(new GradAdmiBean("Jane Doe", new Date(date2.toString()), null, "Application Incomplete"));
		entries.add(new GradAdmiBean("Amy Smith", new Date(date3.toString()), 3.3, "Accepted"));

		getServletContext().setAttribute("statuslst", statuslst);
		getServletContext().setAttribute("entries", entries);

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GradAdmiBean> entries = (List<GradAdmiBean>) getServletContext().getAttribute("entries");
		

		String param = request.getParameter("sort");
		if (param == null) {
			request.getRequestDispatcher("/WEB-INF/CsGradAdmiMainView.jsp").forward(request, response);
		} else {
			if (param.equals("applicant")) {
				Collections.sort(entries);
				request.getRequestDispatcher("/WEB-INF/CsGradAdmiMainView.jsp").forward(request, response);
			}

			if (param.equals("status")) {
				Collections.sort(entries, new Comparator<GradAdmiBean>() {

					@Override
					public int compare(GradAdmiBean o1, GradAdmiBean o2) {

						return o1.getStatus().compareTo(o2.getStatus());
					}
				});
				request.getRequestDispatcher("/WEB-INF/CsGradAdmiMainView.jsp").forward(request, response);
			}

			if (param.equals("gpa")) {

				Collections.sort(entries, new Comparator<GradAdmiBean>() {

					@Override
					public int compare(GradAdmiBean o1, GradAdmiBean o2) {
						if (o1.getGpa() == null) {
							return (o2.getGpa() == null) ? 0 : 1;
						}
						if (o2.getGpa() == null) {
							return -1;
						}
						return o2.getGpa().compareTo(o1.getGpa());
					}
				});
				request.getRequestDispatcher("/WEB-INF/CsGradAdmiMainView.jsp").forward(request, response);
			}
			
			
			
			if( param.equals("dates")){


				/*SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
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
				}*/
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
