package app;

public class Property {
	String propertyId;
	String custId;
	String address;
	String suburb;
	int bedrooms;
	int bathrooms;
	int car_spaces;
	String type;
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getCar_spaces() {
		return car_spaces;
	}
	public void setCar_spaces(int car_spaces) {
		this.car_spaces = car_spaces;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Property(String propertyId, String custId, String address, String suburb, int bedrooms, int bathrooms,
			int car_spaces, String type) {
		super();
		this.propertyId = propertyId;
		this.custId = custId;
		this.address = address;
		this.suburb = suburb;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.car_spaces = car_spaces;
		this.type = type;
	}
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(propertyId)
		.append(",")
		.append(custId)
		.append(",")
		.append(address)
		.append(",")
		.append(suburb)
		.append(",")
		.append(bedrooms)
		.append(",")
		.append(bathrooms)
		.append(",")
		.append(car_spaces)
		.append(",")
		.append(type);
		return sb.toString();
	}
	
	public String printInfo() {
		return "this property address is "+address+", suburb is "+suburb
				+", it has "+bedrooms+" bedroom/s, "
				+bathrooms+ " bathroom/s, "
				+car_spaces+" car space/s "
				+"and property type is "+type;
		
	}

}
