package Models;

import java.util.List;

import Service.strategy.billCalculationStrategy.BillCalculationStrategy;
import Service.strategy.slotAllocationStrategy.SlotAllocationStrategy;
import constants.ParkingLotStatus;
import constants.VehicleType;

public class ParkingLot extends BaseModel {
	private String name;
	private String address;
	private List<ParkingFloor> parkingFloors;
	private ParkingLotStatus parkingLotStatus;
	private List<VehicleType> supportedVehicleTypes;
	private SlotAllocationStrategy slotAllocationStrategy;
	private BillCalculationStrategy billCalculationStrategy;

}
