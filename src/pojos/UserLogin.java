package pojos;

import javax.persistence.*;

@Entity
@Table(name="UserLogin")
public class UserLogin {
	private Integer id;
	private String userName;
	private String password;
	
	public UserLogin()
	{
		System.out.println("in default ctor of user");
	}
	
	public UserLogin(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String user) {
		this.userName= user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
