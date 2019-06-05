package pojos;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SocietyList")
public class SocietyList {
	public SocietyList() {
		super();
		System.out.println("in def cnstr of societylist");
			}
	
	private Integer societyId ;
	private String societyName;
	private String address;
	private String city;
	private String pinCode;
	private int noOfHouse;
	private byte[] image;

	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date entryDate;
	private List<HouseList> houses=new ArrayList<HouseList>();
	
	
	
	public SocietyList(String societyName, String address, String city, String pinCode, int noOfHouse,
			byte[] image, Date entryDate) {
		super();
		this.societyName = societyName;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.noOfHouse = noOfHouse;
		this.image = image;
		this.entryDate = entryDate;
	}
	
	
	
	public SocietyList(String societyName, String address, String city) {
		super();
		this.societyName = societyName;
		this.address = address;
		this.city = city;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSocietyId() {
		return societyId;
	}
	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
	}
	
	@Column(length=50,unique=true)
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	
	@Column(length=50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(length=50)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length=50)
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	@Lob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getNoOfHouse() {
		return noOfHouse;
	}
	public void setNoOfHouse(int noOfHouse) {
		this.noOfHouse =noOfHouse;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	@OneToMany(mappedBy="mySociety",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	public List<HouseList> getHouses() {
		return houses;
	}
	
	public void setHouses(List<HouseList> houses) {
		this.houses = houses;
	}
	
	//convenience methods for houses
			public void addHouses(HouseList s)
			{
				houses.add(s);         // forward assoc course--->student
				s.setMySociety(this);     //setting reverse association  student-->course
			}
			
			
			public void removeHouses(HouseList s)
			{
				houses.remove(s);
			}
	
			
	@Override
	public String toString() {
		return "SocietyList [societyId=" + societyId + ", societyName=" + societyName + ", address=" + address
				+ ", city=" + city + ", pinCode=" + pinCode + ", noOfHouse=" + noOfHouse + ", image="
				+ Arrays.toString(image) + ", entryDate=" + entryDate + ", houses=" + houses + "]";
	}
		
}
