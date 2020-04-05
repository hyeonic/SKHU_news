package kr.or.skhu.news.dto;

import java.util.Date;

// NoticeDto class, notice table 의 항목을 저장하는 javaBeans, toString 메서드만 override 해둠
public class Notice {
	private int id;
	private int categoryId;
	private String noticeTitle;
	private String noticeHref;
	private String noticeWriter;
	private Date createDate;
	private int viewCount;

	public Notice (int id, int categoryId, String category, String noticeTitle, String noticeHref, String noticeWriter, Date createDate, int viewCount) {
		this.id = id;
		this.categoryId = categoryId;
		this.noticeTitle = noticeTitle;
		this.noticeHref = noticeHref;
		this.noticeWriter = noticeWriter;
		this.createDate = createDate;
		this.viewCount = viewCount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeHref() {
		return noticeHref;
	}
	public void setNoticeHref(String noticeHref) {
		this.noticeHref = noticeHref;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", categoryId=" + categoryId +  ", noticeTitle="
				+ noticeTitle + ", noticeHref=" + noticeHref + ", noticeWriter=" + noticeWriter + ", createDate="
				+ createDate + ", viewCount=" + viewCount + "]";
	}
}
