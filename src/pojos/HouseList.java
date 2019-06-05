package pojos;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HouseList")
public class HouseList {
	private int houseId;
	private int blockNo;
	private String type;
	private String detail;
	private String societyName;
	private byte[] image;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date entryDate;
	private UserList user;
	private SocietyList mySociety;
	
	
	
	public HouseList() {
		super();
		System.out.println("in def cnstr of HouseList");
	}
	public HouseList(int blockNo, String type, String detail, String societyName,
			Date entryDate) {
		super();
		this.blockNo = blockNo;
		this.type = type;
		this.detail = detail;
		this.societyName = societyName;
		this.entryDate = entryDate;
	}
	
	
	
	public HouseList(int houseId, int blockNo,String type/*, String detail*/, String societyName, Date entryDate) {
		//super();
		this.houseId = houseId;
		this.blockNo = blockNo;
		this.type = type;
		//this.detail = detail;
		this.societyName = societyName;
		this.entryDate = entryDate;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	@Column(name="Blockno",length=50)
	public int getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(int blockNo) {
		this.blockNo = blockNo;
	}
	@Column(length=50)
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	
	@Lob
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	@Column(name="Type",length=50)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name = "societyId")
	public SocietyList getMySociety() {
		return mySociety;
	}
	public void setMySociety(SocietyList mySociety) {
		this.mySociety = mySociety;
	}
	@Column(name="detail",length=50)
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	@OneToOne(mappedBy="house",cascade=CascadeType.ALL)
	public UserList getUser() {
		return user;
	}
	public void setUser(UserList user) {
		this.user = user;
	}
	
	//Convenience method for user
		public void linkUser(UserList a)
		{
			setUser(a);
			a.setHouse(this);
		}
		
		public void delLinkAddress(UserList a)
		{
			user=null;
			a.setHouse(null);
		}
		
	@Override
	public String toString() {
		return "HouseList [houseId=" + houseId + ", blockNo=" + blockNo + ", type=" + type + ", detail=" + detail
				+ ", societyName=" + societyName + ", image=" + Arrays.toString(image) + ", entryDate=" + entryDate
				+ ", user=" + user + ", mySociety=" + mySociety + "]";
	}
	
	
	
	
}
