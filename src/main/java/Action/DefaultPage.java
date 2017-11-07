package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DefaultPage implements Action{
   public String jspPagePath;
   public DefaultPage(String jspPagePath) {
      this.jspPagePath=jspPagePath;
   }
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ActionForward forward = new ActionForward();
         forward.setNextPath(jspPagePath);
         return forward;
   }
}