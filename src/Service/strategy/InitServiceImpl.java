package Service.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.Gate;
import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import Repository.GateRepository;
import Repository.ParkingFloorRepository;
import Repository.ParkingLotRepository;
import Repository.ParkingSlotRepository;
import Service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;
import Service.strategy.slotAllocationStrategy.SlotAllocationStrategyFactory;
import constants.GateStatus;
import constants.GateType;
import constants.ParkingFloorStatus;
import constants.ParkingLotStatus;
import constants.ParkingSlotStatus;
import constants.VehicleType;

public class InitServiceImpl implements InitService {
	private ParkingSlotRepository parkingSlotRepository;
	private ParkingFloorRepository parkingFloorRepository;
	private ParkingLotRepository parkingLotRepository;
	private GateRepository gateRepository;

	public InitServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingFloorRepository parkingFloorRepository,
			ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
		this.parkingSlotRepository = parkingSlotRepository;
		this.parkingFloorRepository = parkingFloorRepository;
		this.parkingLotRepository = parkingLotRepository;
		this.gateRepository = gateRepository;
	}

	@Override
	public void init() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.setId(1);
		parkingLot.setName("Parking Lot 1");
		parkingLot.setAddress("Street A, City B");
		parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
		parkingLot.setSupportedVehicleTypes(new ArrayList<>(Arrays.asList(VehicleType.BIKE, VehicleType.CAR)));
		parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.getSlotAllocationStrategy());
		parkingLot.setBillCalculationStrategy(BillCalculationStrategyFactory.getBillCalculationStrategy());
		List<ParkingFloor> parkingFloors = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ParkingFloor floor = new ParkingFloor();
			floor.setId(i);
			floor.setFloorNumber(i);
			List<ParkingSlot> parkingSlots = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				ParkingSlot slot = new ParkingSlot();
				slot.setNumber(i * 100 + j);
				slot.setSupportedVehicleType((j % 2 == 0) ? VehicleType.CAR : VehicleType.BIKE);
				slot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
				parkingSlots.add(slot);
				parkingSlotRepository.put(slot);

			}
			floor.setParkingSlots(parkingSlots);
			floor.setParkingFloorStatus(ParkingFloorStatus.OPEN);

			Gate entryGate = new Gate();
			entryGate.setId(i * 10 + 1);
			entryGate.setGateNumber(i * 10 + 1);
			entryGate.setGateType(GateType.ENTRY);
			entryGate.setGateStatus(GateStatus.OPEN);
			entryGate.setOperator("Rahul");
			entryGate.setParkingLotId(1);
			entryGate.setFloorNumber(i);
			gateRepository.put(entryGate);

			Gate exitGate = new Gate();
			exitGate.setId(i * 10 + 2);
			exitGate.setGateNumber(i * 10 + 2);
			exitGate.setGateType(GateType.EXIT);
			exitGate.setGateStatus(GateStatus.OPEN);
			exitGate.setOperator("Ram");
			exitGate.setParkingLotId(1);
			exitGate.setFloorNumber(i);

			gateRepository.put(exitGate);
			parkingFloors.add(floor);
			parkingFloorRepository.put(floor);
		}
		parkingLot.setParkingFloors(parkingFloors);
		parkingLotRepository.put(parkingLot);

		// TODO Auto-generated method stub

	}

}
