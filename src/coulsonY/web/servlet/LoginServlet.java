package coulsonY.web.servlet;

import coulsonY.dao.UserDao;
import coulsonY.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用来接收用户信息
 */
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        // 获取相应参数，并封装成对象
        User loginUser = new User();
//        loginUser.setUsername(request.getParameter("username"));
//        loginUser.setPassword(request.getParameter("password"));
        // 利用beanutils包来进行参数的设置
        Map<String, String[]> pMap = request.getParameterMap();
        try {
            BeanUtils.populate(loginUser,pMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 判断是否有该用户存在
        User user = new UserDao().loginCheck(loginUser);
        if(user == null){
            System.out.println("查无此人！！");
            request.getRequestDispatcher("/failedServlet").forward(request,response);
        }else{
            System.out.println("来者何人！！");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successfulServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
