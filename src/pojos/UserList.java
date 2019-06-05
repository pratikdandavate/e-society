package pojos;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*; //for importing all JPA anno.
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity //to tell hibernate to manage the entity MANDATORY
@Table(name="userList")
public class UserList implements Serializable{
	
    private static final long serialVersionUID = 7290798953394355234L;

	private Integer userId;
	private String firstName;
	private String lastName;
	
	
	
	@Email
	private String email;
	private String mobileNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	private String societyName;
	private int totalMember;
	private String userName;
	private String password;
	private String image;
	private String gender;
	private String salt;
    private String token;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date entryDate;
	private String flag;
	
	private HouseList house;
	private RentHouse rent;
	private SellHouse sell;
	private List<ComplainList> complaint=new ArrayList<>();
	private List<MessageList> messages=new ArrayList<>();
	
	public UserList() {
		System.out.println("in user default");
	}
	
	public UserList(String firstName, String lastName, String email, 
			String mobileNo, Date birthDate,
			String societyName, int totalMember,String image, String userName, 
			String password, Date entryDate,String flag) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.birthDate = birthDate;
		this.societyName = societyName;
		this.totalMember = totalMember;
		this.image=image;
		this.userName = userName;
		this.password = password;
		this.entryDate = entryDate;
		this.flag=flag;
	}
	
	
	public UserList(Integer userId,String firstName, String lastName, String email, String mobileNo, String societyName) {
		super();
		this.userId=userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.societyName = societyName;
	}

	@Id //Mandatory
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(length=20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(length=20)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	
	public int getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(int totalMember) {
		this.totalMember = totalMember;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	@OneToOne
	@JoinColumn(name="HouseId",unique=true)
	public HouseList getHouse() {
		return house;
	}
	public void setHouse(HouseList house) {
		this.house = house;
	}
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	public RentHouse getRent() {
		return rent;
	}
	public void setRent(RentHouse rent) {
		this.rent = rent;
	}
	
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	public SellHouse getSell() {
		return sell;
	}

	public void setSell(SellHouse sell) {
		this.sell = sell;
	}

	@OneToMany(mappedBy="user1",cascade=CascadeType.PERSIST)
	public List<ComplainList> getComplaint() {
		return complaint;
	}

	public void setComplaint(List<ComplainList> complaint) {
		this.complaint = complaint;
	}


	@OneToMany(mappedBy="user",cascade=CascadeType.PERSIST)
	public List<MessageList> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageList> messages) {
		this.messages = messages;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//Convenience method for rent 
	public void linkRentHouse(RentHouse a)
	{
		setRent(a);
		a.setUser(this);
	}
	
	public void delLinkRentHouse(RentHouse a)
	{
		rent=null;
		a.setUser(null);
	}
	
	//Convenience method for sell 
		public void linkSellHouse(SellHouse a)
		{
			setSell(a);
			a.setUser(this);
		}
		
		public void delLinkSellHouse(SellHouse a)
		{
			sell=null;
			a.setUser(null);
		}
	
				//convenience methods for complaint
				public void addComplaint(ComplainList s)
				{
					complaint.add(s);         // forward assoc course--->student
					s.setUser1(this);     //setting reverse association  student-->course
				}
				
				
				public void removeHouses(ComplainList s)
				{
					complaint.remove(s);
				}
		
				
	@Override
	public String toString() {
		return "UserList [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", birthDate=" + birthDate + ", societyName=" + societyName
				+ ", totalMember=" + totalMember + ", userName=" + userName + ", password=" + password + ", image="
				+ "image" + ", entryDate=" + entryDate + ", house=" + house + ", rent=" + rent + "]";
	}

	
	
}
