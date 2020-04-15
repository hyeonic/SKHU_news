package kr.or.skhu.news.network;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JavaNetwork {


	public static void main(String[] args)  {
	//	http://www.skhu.ac.kr/board/boardread.aspx?idx=34775&curpage=3&bsid=10004
	//	http://www.skhu.ac.kr/board/boardread.aspx?idx=34946&curpage=3&bsid=10004
		String url = "http://www.skhu.ac.kr/board/boardread.aspx?idx=34946&curpage=3&bsid=10004";
		Document doc = null;

		String s = "";
		String f = "";
		String i = "";

		try {
			doc = Jsoup.connect(url).get();
		}catch (IOException e) {
			e.printStackTrace();
		}

		Elements element = doc.select(".board_view tbody tr");

		for (Element el : element) {
			f += el.select("tr:nth-child(2)").html();
			f += "\n";

			i += el.select("tr:nth-child(3)").html();
			i += "\n";

			s += "<tr>";
			s += el.select("tr:nth-child(2)").html();
			s += "</tr>";
			s += "<br>";
			s += "<tr>";
			s += el.select("tr:nth-child(3)").html();
			s += "</tr>";
			s += "</tbody> </body> </html>";

//			System.out.println(el.select("tr:nth-child(2)").html());
//			System.out.println(el.select("tr:nth-child(3)").html());
		}
		String[] fSplit = f.split("href=\"");
		String[] iSplit = i.split("img alt=\"\" src=\"");

		f = ""; i = "";
		for(int ab = 1; ab < fSplit.length; ab++)
		{
			f += (fSplit[ab].split("\"")[0]);
			f += "\n";
		}

		for(int ab = 1; ab < iSplit.length; ab++)
		{
			i += (iSplit[ab].split("\"")[0]);
			i += "\n";
		}
		s = s.replaceAll("\"/common", "\"http://www.skhu.ac.kr/common");
		f = f.replaceAll("/common", "http://www.skhu.ac.kr/common");
		i = i.replaceAll("/common", "http://www.skhu.ac.kr/common");
		// "/common = http://www.skhu.ac.kr/common

		String httpInfo ="<!DOCTYPE HTML>";
		httpInfo += "<html>";
		httpInfo += "<head>";
		httpInfo += "<link type='text/css' href='http://www.skhu.ac.kr/common/css/reset.css' rel='stylesheet' charset='euc-kr'>";
		httpInfo += "<link type='text/css' href='http://www.skhu.ac.kr/common/css/common.css' rel='stylesheet' charset='euc-kr'>";
		httpInfo += "<link type='text/css' href='http://www.skhu.ac.kr/common/css/layout.css' rel='stylesheet' charset='euc-kr'>";
		httpInfo += "<link type='text/css' href='http://www.skhu.ac.kr/common/css/sub.css' rel='stylesheet' charset='euc-kr'>";
		httpInfo += "<link type='text/css' href='http://www.skhu.ac.kr/common/css/kseek/introduce.css' rel='stylesheet' charset='euc-kr'>";
		httpInfo += "<link type='text/css' href='http://www.skhu.ac.kr/common/css/kseek/ideals_of_edu.css' rel='stylesheet' charset='euc-kr'>";
		httpInfo += "<style> #content{ float: none; margin: 0 auto; } </style> </head>";
		httpInfo += "<body> <tbody>";
		httpInfo += s;

		//f, i, httpInfo
//		System.out.println("\n\n" + httpInfo + "\n\n");
//		System.out.println("\n\n" + f + "\n\n");
//		System.out.println("\n\n" + i + "\n\n");

	}

}

