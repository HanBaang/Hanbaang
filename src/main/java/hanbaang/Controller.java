package hanbaang;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.*;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		System.out.println(RequestURI);
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		System.out.println(command);
		// 커맨드에 해당하는 액션을 실행한다.
		try {
			// 화면전환

			action = Configuration.actions.get(command);
			
			if (action == null) {
				//에러 처리
			}
			forward = action.execute(request, response);
			System.out.println(forward);
			// 화면이동 - isRedirext() 값에 따라 sendRedirect 또는 forward를 사용
			// sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
			// forward : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request와 response 객체를 공유
			if (forward != null) {
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	            doProcess(request,response);
	    }      
	        
	    /**
	     * POST 방식일 경우 doPost()
	     */
	    public void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	            doProcess(request,response);
	    }                          
	        

}
