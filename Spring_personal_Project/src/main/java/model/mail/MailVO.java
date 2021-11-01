package model.mail;

public class MailVO {
	private String subject;
	private String content;
	private String from;
	private String to;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "MailVO [subject=" + subject + ", content=" + content + ", from=" + from + ", to=" + to
				+ ", getSubject()=" + getSubject() + ", getContent()=" + getContent() + ", getFrom()=" + getFrom()
				+ ", getTo()=" + getTo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
