package Models;

import constants.GateStatus;
import constants.GateType;

public class Gate extends BaseModel {
	
		private String operator;
		private GateType gateType;
		private int floorNumber;
		private int parkingLotId;
		private GateStatus gateStatus;
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
		public GateType getGateType() {
			return gateType;
		}
		public void setGateType(GateType gateType) {
			this.gateType = gateType;
		}
		public int getFloorNumber() {
			return floorNumber;
		}
		public void setFloorNumber(int floorNumber) {
			this.floorNumber = floorNumber;
		}
		public int getParkingLotId() {
			return parkingLotId;
		}
		public void setParkingLotId(int parkingLotId) {
			this.parkingLotId = parkingLotId;
		}
		public GateStatus getGateStatus() {
			return gateStatus;
		}
		public void setGateStatus(GateStatus gateStatus) {
			this.gateStatus = gateStatus;
		}
			 
	

}
