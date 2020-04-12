//package kr.or.skhu.news.service.impl;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import kr.or.skhu.news.config.ApplicationConfig;
//import kr.or.skhu.news.dao.NoticeDao;
//
//public class test {
//
//	public static void main(String[] args) {
//
//		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		NoticeDao nd = ac.getBean(NoticeDao.class);
//
//		System.out.println();

//		for (int i = 1; i <= 1; ++i) {
//
//			String url = "http://www.skhu.ac.kr/board/boardlist.aspx?curpage="+ i + "&bsid=10008";
//			Document doc = null;
//
//			try {
//				doc = Jsoup.connect(url).get();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			Elements element = doc.select("table.board_list tbody tr");
//
//			for(Element el : element) { // for (type 변수이름 : 순회할 리스트)
//				if (el.select("td:nth-child(1)").text().toString().equals("공지")) {
//					System.out.println(Integer.parseInt(el.select("td:nth-child(2) a").attr("href").substring(19, 24))); // 19 ~ 24 idx
//					System.out.println(50); // category_id
//					System.out.println(el.select("td:nth-child(2)").text()); // title
//					System.out.println(el.select("td:nth-child(2) a").attr("href")); // href
//					System.out.println(el.select("td:nth-child(4)").text()); // writer
//					System.out.println(el.select("td:nth-child(5)").text()); // create_date
//					System.out.println(el.select("td:nth-child(6)").text()); // view_Count
//					System.out.println("");
//					Notice notice = new Notice(Integer.parseInt(el.select("td:nth-child(2) a").attr("href").substring(19, 24))
//							                  , 50
//							                  , el.select("td:nth-child(2)").text()
//							                  , el.select("td:nth-child(2) a").attr("href")
//							                  , el.select("td:nth-child(4)").text()
//							                  , el.select("td:nth-child(5)").text()
//							                  , Integer.parseInt(el.select("td:nth-child(6)").text()));
//
//					nd.insert(notice);
//
//				}else {
//					System.out.println(Integer.parseInt(el.select("td:nth-child(2) a").attr("href").substring(19, 24))); // 19 ~ 24 idx
//					System.out.println(5); // category_id
//					System.out.println(el.select("td:nth-child(2)").text()); // title
//					System.out.println(el.select("td:nth-child(2) a").attr("href")); // href
//					System.out.println(el.select("td:nth-child(4)").text()); // writer
//					System.out.println(el.select("td:nth-child(5)").text()); // create_date
//					System.out.println(el.select("td:nth-child(6)").text()); // view_Count
//					System.out.println("");
//					Notice notice = new Notice(Integer.parseInt(el.select("td:nth-child(2) a").attr("href").substring(19, 24))
//							                  , 5
//							                  , el.select("td:nth-child(2)").text()
//							                  , el.select("td:nth-child(2) a").attr("href")
//							                  , el.select("td:nth-child(4)").text()
//							                  , el.select("td:nth-child(5)").text()
//							                  , Integer.parseInt(el.select("td:nth-child(6)").text()));
//
//					nd.insert(notice);
//				}
//			}
//		}
//	}
//}
