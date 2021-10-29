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
		// 크롤링해 올 url 지정 
				// 알라딘 홈페이지 소설/시/희곡 베스트 셀러 페이지 크롤링
				String url ="https://sasamegoto-ouo.tistory.com/category";
				Document doc = null;
				
				PostForCafeDAO dao = new PostForCafeDAO();
				PostForCafeVO vo = new PostForCafeVO();
				
				
				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(doc);	//확인용
				System.out.println("[스크랩해온 데이터 END]===================================================");
				
				System.out.println("[필요한 데이터 추출]===================================================");	
				// 베스트셀러 책 제목만 추출하기 위해 
				Iterator<Element> itr = (doc).select("section>article>div>div").iterator();
				
				// select(): Elements 를 반환받음
				// Iterator<Elements>에 Elements을 저장함

				
				int cnt = 0; // 데이터가 너무 많으므로  데이터 컷팅하기 위한 cnt변수 선언&초기화
				while(itr.hasNext()) {	//Iterator로 한줄씩 나눈 데이터를  while문을 통해 DB에 넣는다.
		//********************************************************************************
					System.out.println();
					System.out.println(itr.next());	// 크롤링한 내용중 어떤 내용이 들어가는지 확인용 출력
		//********************************************************************************
	/*				vo.setTitle(cutTitle(itr.next().toString()));
					vo.setThumnail(thumnail);
					vo.setLocation(location);
					vo.setLocaddress(locaddress);
					vo.setLoccall(loccall);
					vo.setContent(content);
					*/
					// bestselleVO의 title에 셋팅 하는데 이때 셋팅 하는 내용은  <>태그를 제거한 제목만
					// <>를 컷팅하는 cutTitle 사용자 정의함수 사용
					//dao.insertBestseller(vo);
					// dao의 insert를 사용하여 DB테이블에 저장한다.
					// 데이터가 너무 많아서 5개만 저장하기 위해 cnt 변수를 생성하여
					cnt++;	// 데이터 하나가 들어가면 cnt를 하나씩 올린다.
					if(cnt == 100) {	// cnt가 5이 되면 insert를 멈춘다.
						System.out.println("그만!");
						break;			
					}	
				} 
/*				ArrayList<bestsellerVO> datas = dao.selectAllBestseller(vo); 
				// DB에 저장된 데이터들! 을 보기 위해 selectAll을 사용			
				System.out.println();
				System.out.println("========[ BESTSELLER]========");
				for (bestsellerVO v : datas) {
					System.out.println(v);
				}*/
			}

	}
//}
