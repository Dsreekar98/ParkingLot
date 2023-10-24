package DTO;

public class TicketResponseDTO {
	private String entryTime;
	private String vehileNumber;
	private int slotNumber;
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getVehileNumber() {
		return vehileNumber;
	}
	public void setVehileNumber(String vehileNumber) {
		this.vehileNumber = vehileNumber;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	@Override
	public String toString() {
		return "TicketResponseDTO [entryTime=" + entryTime + ", vehileNumber=" + vehileNumber + ", slotNumber="
				+ slotNumber + "]";
	}
	
}
