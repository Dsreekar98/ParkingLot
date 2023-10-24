package Controller;

import java.time.LocalDateTime;

import DTO.TicketRequestDTO;
import DTO.TicketResponseDTO;
import Exceptions.GateNotFoundException;
import Exceptions.NoParkingSlotAvailableException;
import Exceptions.ParkingLotNotFoundException;
import Models.Ticket;
import Models.Vehicle;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;
import Service.TicketService;
import Service.TicketServiceImpl;

public class TicketController {
	
	
	public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
		this.ticketService = new TicketServiceImpl(parkingLotRepository,gateRepository,ticketRepository);
	}

	private TicketService ticketService;
	
	public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException {
		Vehicle vehicle=new Vehicle(ticketRequestDTO.getNumber(),ticketRequestDTO.getName(),ticketRequestDTO.getColor(),ticketRequestDTO.getVehicleType());
		Ticket ticket=ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(), ticketRequestDTO.getParkingLotId(), LocalDateTime.now());
		TicketResponseDTO ticketResponseDTO=new TicketResponseDTO();
		ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
		ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getNumber());
		ticketResponseDTO.setVehileNumber(ticket.getVehicle().getNumber());
		return ticketResponseDTO;
	}

}
