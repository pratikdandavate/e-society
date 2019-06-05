package pojos;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="rentHouse")
public class RentHouse {
	private Integer rentId;
	private int houseId;
	private String societyName;
	private float rentPrice;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date entryDate;
	private UserList user;
	
	public RentHouse() {
		System.out.println("in def rentHouse");
}
	
	public RentHouse(int houseId, String societyName, int rentPrice, Date entryDate) {
		super();
		this.houseId = houseId;
		this.societyName = societyName;
		this.rentPrice = rentPrice;
		this.entryDate = entryDate;
	}
	
	public RentHouse(Integer rentId,int houseId, String societyName, float rentPrice,Date entryDate) {
		super();
		this.houseId = houseId;
		this.rentId = rentId;
		this.societyName = societyName;
		this.rentPrice = rentPrice;
		this.entryDate = entryDate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
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

	public float getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
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
		return "RentHouse [rentId=" + rentId + ", houseId=" + houseId + ", societyName=" + societyName + ", rentPrice="
				+ rentPrice + ", entryDate=" + entryDate + ", user=" + user + "]";
	}
		
}
