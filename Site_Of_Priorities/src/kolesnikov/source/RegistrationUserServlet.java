package kolesnikov.source;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationUserServlet")
public class RegistrationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    private Users user = new Users();
    private ObjectsController controller = new ObjectsController();
    private Pattern loginPat = Pattern.compile("^[A-Za-z0-9]{1,15}$");   // �������� ������
    private Pattern passwordPat = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).[^ ]{5,10}$");   // �������� ������
    private Pattern namePat = Pattern.compile("^[A-Za-z�-��-�']{1,10}$");   // �������� �����
    private Matcher loginMat = null;
    private Matcher passwordMat = null;
    private Matcher nameMat = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = new String(request.getParameter("button").getBytes("ISO-8859-1"),"UTF-8");
		
		//���� ������ ������ �����
		if(name.equals("�����")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/authorization_user.jsp");
			dispatcher.include(request, response);
		}
		else {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		
		
			//��� �������� ���������� ������
			System.out.println(login);
			System.out.println(password);
			System.out.println(name);
		
			if(login.length()>=1 && password.length()>=1) {
				user.setLogin(login);
				loginMat = loginPat.matcher(login);
				// ���� ����� �� ������������� �����������
				if(!loginMat.matches()) {
					request.setAttribute("incorrectLogin", "����� ����� ��������� ������ ��������� ����� � ����� (�� ����� 15 ��������)");
				}
		    
				user.setHashSum(password);
				passwordMat = passwordPat.matcher(password);
				// ���� ������ �� ������������� �����������
				if(!passwordMat.matches()) {
					request.setAttribute("incorrectPassword", "������ ������ �������� �� ����, �������� � ������� ��������� (�� ����� 5 � �� ����� 10 ��������)");	
				}
		    
				user.setAccountType("user");
				if(name.length()>=1) {
					user.setName(name);
					nameMat = namePat.matcher(name);
					// ���� ������ �� ������������� �����������
					if(!nameMat.matches()) {
						request.setAttribute("incorrectName", "��� ������ ���� ������ �� ���� (�� ����� 10 ��������)");	
					}
				}
				if(loginMat.matches() && passwordMat.matches() && name.length() < 1 || loginMat.matches() && passwordMat.matches() && nameMat.matches()) {
					boolean check = controller.addObjectToDatabase(user);  // ���������� �������� ������������ � ��
					// ���� ������� ���������
					if(check) {
						System.out.println("������������ ��������� � ��");
						request.setAttribute("loginComplete", user.getLogin());
						request.setAttribute("welcomeNewUser", "���������� �� �����������!");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome_user.jsp");
						dispatcher.include(request, response);
					}
					else {
						System.out.println("������������ �� ��������� � ��");
						request.setAttribute("multiName", "��������, ������������ � ����� ������� ��� ����������");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/registration_user.jsp");
						dispatcher.include(request, response);
					}
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/registration_user.jsp");
					dispatcher.include(request, response);
				}
			}
			//���� ������� �� ���������
			else {
				System.out.println("����� ������ �������");
				if(login.length()<1)
					request.setAttribute("incorrectLogin", "��� ���� �� ����� ���� ������");
				if(password.length()<1)
					request.setAttribute("incorrectPassword", "��� ���� �� ����� ���� ������");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/registration_user.jsp");
				dispatcher.include(request, response);
			}
		}
	}
}
