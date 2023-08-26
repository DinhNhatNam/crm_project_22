package crm_project.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@WebFilter(filterName = "authfilter", urlPatterns = {"/addrole","/readrole"})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		HttpServletRequest re= (HttpServletRequest) request;
		String pa = re.getServletPath();
		HttpSession ses = re.getSession();
		System.out.println(pa);
		if(pa.contains("role")) {
			String check = (String) ses.getAttribute("email");
			if(check==null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				chain.doFilter(request, response);
			}
		}
		
	}

}
