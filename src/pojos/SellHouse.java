package pojos;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SellHouse")
public class SellHouse {
	private Integer sellId;
	private int houseId;
	private String societyName;
	private float sellPrice;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date entryDate;
	private UserList user;
	
	
	

	public SellHouse() {
		System.out.println("in def cnstr of sell house");
	}

	public SellHouse(int houseId, String societyName, int sellPrice, Date entryDate) {
		super();
		this.houseId = houseId;
		this.societyName = societyName;
		this.sellPrice = sellPrice;
		this.entryDate = entryDate;
	}
	
	public SellHouse(Integer sellId,int houseId, String societyName, float sellPrice,Date entryDate) {
		super();
		this.houseId = houseId;
		this.sellId = sellId;
		this.societyName = societyName;
		this.sellPrice = sellPrice;
		this.entryDate = entryDate;
		
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getSellId() {
		return sellId;
	}

	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	@Column(length=50)
	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@OneToOne
	@JoinColumn(name="UserId")
	public UserList getUser() {
		return user;
	}

	public void setUser(UserList user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SellHouse [sellId=" + sellId + ", houseId=" + houseId + ", societyName=" + societyName + ", sellPrice="
				+ sellPrice + ", entryDate=" + entryDate + ", user=" + user + "]";
	}

	
}
