package kr.co.saramin.mysite3.vo;

public class BoardVo {
	private Long   no;
	private String title;
	private String content;
	private Long   viewCount;
	private String regDate;
	private Long userNo;
	
	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getViewCount() {
        return viewCount;
    }
    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
    public Long getUserNo() {
        return userNo;
    }
    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }
    public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
    @Override
    public String toString() {
        return "BaordVo [no=" + no + ", title=" + title + ", content="
                + content + ", viewCount=" + viewCount + ", regDate=" + regDate
                + ", userNo=" + userNo + "]";
    }
    
	
	
}
