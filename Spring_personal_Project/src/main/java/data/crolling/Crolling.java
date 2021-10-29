package data.crolling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import model.postforcafe.PostForCafeDAO;
import model.postforcafe.PostForCafeVO;

public class Crolling {
	static String cutTitle(String str) { 	
		str=str.substring(0,str.lastIndexOf("<"));
		str=str.substring(str.lastIndexOf(">")+1);
		return str; 
	}
	public static void main(String[] args) {
		// ũ�Ѹ��� �� url ���� 
				// �˶�� Ȩ������ �Ҽ�/��/��� ����Ʈ ���� ������ ũ�Ѹ�
				String url ="https://sasamegoto-ouo.tistory.com/category";
				Document doc = null;
				
				PostForCafeDAO dao = new PostForCafeDAO();
				PostForCafeVO vo = new PostForCafeVO();
				
				
				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(doc);	//Ȯ�ο�
				System.out.println("[��ũ���ؿ� ������ END]===================================================");
				
				System.out.println("[�ʿ��� ������ ����]===================================================");	
				// ����Ʈ���� å ���� �����ϱ� ���� 
				Iterator<Element> itr = (doc).select("section>article>div>div").iterator();
				
				// select(): Elements �� ��ȯ����
				// Iterator<Elements>�� Elements�� ������

				
				int cnt = 0; // �����Ͱ� �ʹ� �����Ƿ�  ������ �����ϱ� ���� cnt���� ����&�ʱ�ȭ
				while(itr.hasNext()) {	//Iterator�� ���پ� ���� �����͸�  while���� ���� DB�� �ִ´�.
		//********************************************************************************
					System.out.println();
					System.out.println(itr.next());	// ũ�Ѹ��� ������ � ������ ������ Ȯ�ο� ���
		//********************************************************************************
	/*				vo.setTitle(cutTitle(itr.next().toString()));
					vo.setThumnail(thumnail);
					vo.setLocation(location);
					vo.setLocaddress(locaddress);
					vo.setLoccall(loccall);
					vo.setContent(content);
					*/
					// bestselleVO�� title�� ���� �ϴµ� �̶� ���� �ϴ� ������  <>�±׸� ������ ����
					// <>�� �����ϴ� cutTitle ����� �����Լ� ���
					//dao.insertBestseller(vo);
					// dao�� insert�� ����Ͽ� DB���̺� �����Ѵ�.
					// �����Ͱ� �ʹ� ���Ƽ� 5���� �����ϱ� ���� cnt ������ �����Ͽ�
					cnt++;	// ������ �ϳ��� ���� cnt�� �ϳ��� �ø���.
					if(cnt == 100) {	// cnt�� 5�� �Ǹ� insert�� �����.
						System.out.println("�׸�!");
						break;			
					}	
				} 
/*				ArrayList<bestsellerVO> datas = dao.selectAllBestseller(vo); 
				// DB�� ����� �����͵�! �� ���� ���� selectAll�� ���			
				System.out.println();
				System.out.println("========[ BESTSELLER]========");
				for (bestsellerVO v : datas) {
					System.out.println(v);
				}*/
			}

	}
//}
