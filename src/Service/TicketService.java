package Service;

import java.time.LocalDateTime;

import Exceptions.GateNotFoundException;
import Exceptions.NoParkingSlotAvailableException;
import Exceptions.ParkingLotNotFoundException;
import Models.Ticket;
import Models.Vehicle;

public interface TicketService {
	Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException;

}
