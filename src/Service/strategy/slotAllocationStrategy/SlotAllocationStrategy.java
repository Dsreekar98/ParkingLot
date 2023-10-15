package Service.strategy.slotAllocationStrategy;

import Models.Gate;
import Models.ParkingLot;
import Models.ParkingSlot;
import constants.VehicleType;

public interface SlotAllocationStrategy {
	ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot,Gate entryGate);

}
