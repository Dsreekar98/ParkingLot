package Service.strategy.slotAllocationStrategy;

import Exceptions.NoParkingSlotAvailableException;
import Models.Gate;
import Models.ParkingLot;
import Models.ParkingSlot;
import constants.ParkingSlotStatus;
import constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy {

	@Override
	public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) throws NoParkingSlotAvailableException {
		int floorNumber = entryGate.getFloorNumber();
		for (ParkingSlot slot : parkingLot.getParkingFloors().get(floorNumber).getParkingSlots()) {
			if (slot.getSupportedVehicleType().equals(vehicleType)
					&& slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
				return slot;
			}
		}
		int i = floorNumber - 1;
		int j = floorNumber + 1;
		while (i >= 0 || j < parkingLot.getParkingFloors().size()) {
			if (i >= 0) {
				for (ParkingSlot slot : parkingLot.getParkingFloors().get(floorNumber).getParkingSlots()) {
					if (slot.getSupportedVehicleType().equals(vehicleType)
							&& slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
						return slot;
					}
				}
			}
			if (j < parkingLot.getParkingFloors().size()) {
				for (ParkingSlot slot : parkingLot.getParkingFloors().get(floorNumber).getParkingSlots()) {
					if (slot.getSupportedVehicleType().equals(vehicleType)
							&& slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
						return slot;
					}
				}
			}
			i++;
			i--;
		}
		throw new NoParkingSlotAvailableException("No empty parking slot available");
	}
}
