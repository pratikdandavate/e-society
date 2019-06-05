package pojos;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ComplainList")
public class ComplainList {
	private int complaintId;
	private String subject;
	private String complaint;
	private String reply;
	private String status;
	
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date entryDate;
	private UserList user1;
	
	
	public ComplainList() {
		System.out.println("in def complain");
	}
	public ComplainList(String subject, String complaint, String reply, String status, Date entryDate) {
		super();
		this.subject = subject;
		this.complaint = complaint;
		this.reply = reply;
		this.status = status;
		this.entryDate = entryDate;
		}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	
	@Column(length=200)
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	

	@Column(length=500)
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	
	@ManyToOne
	@JoinColumn(name = "userId")
	public UserList getUser1() {
		return user1;
	}

	public void setUser1(UserList user1) {
		this.user1 = user1;
	}


	@Column(length=200)
	public String getReply() {
		return reply;
	}
	
	public void setReply(String reply) {
		this.reply = reply;
	}
	

	@Column(length=50)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	


	
	@Override
	public String toString() {
		return "ComplainList [complaintId=" + complaintId + ", subject=" + subject + ", complaint=" + complaint
				+ ", reply=" + reply + ", status=" + status + ", entryDate=" + entryDate + "]";
	}

	
	

}
