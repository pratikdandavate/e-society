package pojos;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
	private Integer id;
	private String user;
	private String password;
	
	public User()
	{
		System.out.println("in default ctor of user");
	}
	
	public User(String user, String password) {
		super();
		this.user = user;
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

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user= user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
