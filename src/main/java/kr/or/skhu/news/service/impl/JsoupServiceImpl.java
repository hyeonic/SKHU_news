package kr.or.skhu.news.service.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.skhu.news.dao.NoticeDao;
import kr.or.skhu.news.dto.Notice;
import kr.or.skhu.news.service.JsoupService;

// 5분 마다 클롱링하여 새로운 notice list를 DB에 저장
@Service
public class JsoupServiceImpl implements JsoupService {

	@Autowired
	NoticeDao noticeDao;

	@Override
	@Transactional
	@Scheduled(fixedDelay = 300000)
	public void execute() {
		System.out.println("5분마다 출력");

		for (int i = 4; i <= 8; ++i) {
			String url = "http://www.skhu.ac.kr/board/boardlist.aspx?curpage=1&bsid=1000" + i;
			Document doc = null;

			try {
				doc = Jsoup.connect(url).get();
			}catch (IOException e) {
				e.printStackTrace();
			}

			Elements element = doc.select("table.board_list tbody tr");

			for (Element el : element) {
				if (el.select("td:nth-child(1)").text().toString().equals("공지")) {
				}else if (noticeDao.findByIdx(Integer.parseInt(el.select("td:nth-child(2) a").attr("href").substring(19, 24))) == 0) {
					Notice notice = new Notice(Integer.parseInt(el.select("td:nth-child(2) a").attr("href").substring(19, 24))
											   , (i - 3)
											   , el.select("td:nth-child(2)").text()
											   , el.select("td:nth-child(2) a").attr("href")
											   , el.select("td:nth-child(4)").text()
											   , el.select("td:nth-child(5)").text()
											   , Integer.parseInt(el.select("td:nth-child(6)").text()));
					System.out.println(notice.toString());
					noticeDao.insert(notice);
				}
			}

		}
	}
}

