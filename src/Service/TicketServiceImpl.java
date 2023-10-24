package Service;

import java.time.LocalDateTime;

import Exceptions.GateNotFoundException;
import Exceptions.NoParkingSlotAvailableException;
import Exceptions.ParkingLotNotFoundException;
import Models.ParkingLot;
import Models.ParkingSlot;
import Models.Ticket;
import Models.Vehicle;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;

public class TicketServiceImpl implements TicketService{
private ParkingLotRepository parkingLotRepository;
private GateRepository gateRepository;
private TicketRepository ticketRepository;

	
	public TicketServiceImpl(ParkingLotRepository parkingLotRepository, GateRepository gateRepository,
		TicketRepository ticketRepository) {
	super();
	this.parkingLotRepository = parkingLotRepository;
	this.gateRepository = gateRepository;
	this.ticketRepository = ticketRepository;
}


	@Override
	public Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException {
		// TODO Auto-generated method stub
		ParkingLot parkingLot=parkingLotRepository.get(parkingLotId);
		ParkingSlot assignedParkingSlot=parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(), parkingLot,gateRepository.get(gateId));
		Ticket ticket=new Ticket();
		ticket.setEntryTime(entryTime);
		ticket.setVehicle(vehicle);
		ticket.setParkingSlot(assignedParkingSlot);
		ticketRepository.put(ticket);
		return ticket;
	}
	

}
