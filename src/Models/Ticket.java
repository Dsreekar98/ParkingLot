package Models;

import java.time.LocalDateTime;

import constants.TicketSatus;

public class Ticket extends BaseModel{
	private Vehicle vehicle;
	private LocalDateTime entryTime;
	private ParkingSlot parkingSlot;
	private Gate gate;
	private TicketSatus ticketStatus;
	private static int ticketCounter=1;
	public Ticket() {
		super(ticketCounter++);
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public Gate getGate() {
		return gate;
	}
	public void setGate(Gate gate) {
		this.gate = gate;
	}
	public TicketSatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketSatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	

}
