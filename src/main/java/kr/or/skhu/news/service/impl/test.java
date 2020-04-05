package kr.or.skhu.news.service.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.skhu.news.config.ApplicationConfig;
import kr.or.skhu.news.dao.NoticeDao;
import kr.or.skhu.news.dto.Notice;

public class test {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		NoticeDao nd = ac.getBean(NoticeDao.class);
		Notice notice = null;

		for (int i = 1; i <= 68; ++i) {

			String url = "http://www.skhu.ac.kr/board/boardlist.aspx?curpage="+ i + "&bsid=10004&searchBun=51";
			Document doc = null;

			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Elements element = doc.select("tr");

			for(Element el : element) { // for (type 변수이름 : 순회할 리스트)
				System.out.println(el.select("td:nth-child(1)").text()); // No
				if (el.select("td:nth-child(1)").text().equals("공지")) {
					notice.setId(0);
				}

				System.out.println(el.select("td:nth-child(2)").text()); // title
				System.out.println(el.select("td:nth-child(2) a").attr("href")); // href
				System.out.println(el.select("td:nth-child(3)").text()); // writer
				System.out.println(el.select("td:nth-child(4)").text()); // create_date
				System.out.println(el.select("td:nth-child(5)").text()); // view_Count

			}
		}
	}

}
