package DTO;

import constants.VehicleType;

public class TicketRequestDTO {
	private int parkingLotId;
	private int gateId;
	private String number;
	private String color;
	private VehicleType vehicleType;
	private String name;
	public int getParkingLotId() {
		return parkingLotId;
	}
	public int getGateId() {
		return gateId;
	}
	public String getNumber() {
		return number;
	}
	public String getColor() {
		return color;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public String getName() {
		return name;
	}
	public void setParkingLotId(int parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
	public void setGateId(int gateId) {
		this.gateId = gateId;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
