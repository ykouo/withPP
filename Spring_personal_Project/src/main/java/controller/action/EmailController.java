package controller.action;

public class MailController {
	
/*	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		System.out.println("���� �׼� ����" + request.getParameter("uid"));
		System.out.println("���� �׼� ����" + request.getParameter("mymail"));

		MemDAO mDAO = new MemDAO();
		MemVO mVO = new MemVO();
		String mid = request.getParameter("uid");

		// public MemVO SelectOne(MemVO vo) {
		mVO.setMid(mid);

		if (mDAO.SelectOne(mVO) == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�������� �ʴ� ���̵��Դϴ�.');history.go(-1);</script>");
		} else {
			MailSend sender = new MailSend();
			String mcontent = sender.MailSend((String) request.getParameter("mymail"));
			mVO.setMpw(mcontent);
			// ������Ʈ
			mDAO.UpdatePW(mVO);

			System.out.println(mcontent);

		}

		return forward;
	}
	*/
	
	
/*	package controller.action;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Properties;

	import javax.mail.Address;
	import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import web.mail.MailAuth;

	public class QAMailSendAction implements Action{

		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			ActionForward forward = null;
			
			PrintWriter out = response.getWriter();

			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content"); // �̸���
			//String content2 = request.getParameter("content2"); // ���ǳ���

			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "587");

			Authenticator auth = new MailAuth();

			Session session = Session.getDefaultInstance(prop, auth);

			MimeMessage msg = new MimeMessage(session);

			try {

				session.setDebug(true);

				msg.setSubject(subject); // ����
				Address fromAddr = new InternetAddress(from);
				msg.setFrom(fromAddr); // ������ ���

				Address toAddr = new InternetAddress(to);
				msg.addRecipient(Message.RecipientType.TO, toAddr); // �޴� ���

				msg.setContent("<h4>�亯���� �����ּ� :"+fromAddr+"</h4><hr><h3><b>���ǳ���</b></h3><br><p>"+content+"</p>", "text/html;charset=UTF-8"); // ����� ���ڵ�
			//<h3>"+fromAddr+"���� ���ǳ����Դϴ�.</h3><br><hr><h4>���ǳ���</h4>"+content
				//msg.setContent(content2, "text/html;charset=UTF-8"); // ����� ���ڵ�

				Transport.send(msg); // ����


			} catch (Exception e) {
				e.printStackTrace();
				out.println("<script>alert('[Fail] Sorry T^T');history.back();</script>");
				// ���� �߻��� �ڷ� ���ư�����
			}

			out.println("<script>alert('[Success]Thanks!');location.href='contact.jsp';</script>");
			// ���� ��
		
			return forward;
		}

	}*/

}
