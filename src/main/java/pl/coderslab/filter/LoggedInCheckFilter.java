//package pl.coderslab.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import pl.coderslab.entity.PersonalTrainer;
//
//
//
//// @WebFilter registers filter immediately without any other configuration
//@WebFilter(description = "Check if trainer is logged in and if not then redirect", urlPatterns = { "/*" })
//public class LoggedInCheckFilter extends OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		final HttpServletRequest req = (HttpServletRequest) request;
//		final String url = req.getRequestURL().toString();
//
//		if (allowedToEveryone(url)) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//
//		HttpSession session = req.getSession();
//		PersonalTrainer trainer = (PersonalTrainer) session.getAttribute("loggedInPersonalTrainer");
//
//		if (trainer == null) {
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
//			httpResponse.sendRedirect(req.getContextPath() + "/home");
//			return;
//		}
//
//		filterChain.doFilter(request, response);
//	}
//
//	private boolean allowedToEveryone(final String url) {
//		if (url.endsWith("/register")
//		 || url.endsWith("/login") || url.endsWith("/home")) {
//			return true;
//		}
//
//		return false;
//	}
//}