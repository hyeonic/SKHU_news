package kr.or.skhu.news.dto;

public class NoticeDetail {
	private int id;
	private int idx;
	private String html;

	public NoticeDetail() {
	}

	public NoticeDetail(int idx, String html) {
		this.idx = idx;
		this.html = html;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getidx() {
		return idx;
	}

	public void setidx(int idx) {
		this.idx = idx;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	@Override
	public String toString() {
		return "NoticeDetail [id=" + id + ", idx=" + idx + ", html=" + html + "]";
	};
}
