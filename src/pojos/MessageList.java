package pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MessageList")
public class MessageList {
	private int mId;
	private String fromName;
	private String toName;
	private String message;
	
	private UserList user;
	public MessageList() {
		super();
	}
	public MessageList(int mId, String fromName, String toName, String message) {
		super();
		this.mId = mId;
		this.fromName = fromName;
		this.toName = toName;
		this.message = message;
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	
	@Column(length=500)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	public UserList getUser() {
		return user;
	}
	public void setUser(UserList user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "MessageList [mId=" + mId + ", fromName=" + fromName + ", toName=" + toName + ", message=" + message
				+ "]";
	}
	
	
	
	
	

}
