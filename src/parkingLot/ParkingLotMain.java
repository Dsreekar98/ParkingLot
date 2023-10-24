package parkingLot;

import Controller.TicketController;
import DTO.TicketRequestDTO;
import DTO.TicketResponseDTO;
import Exceptions.GateNotFoundException;
import Exceptions.NoParkingSlotAvailableException;
import Exceptions.ParkingLotNotFoundException;
import Models.ParkingLot;
import Repository.GateRepository;
import Repository.ParkingFloorRepository;
import Repository.ParkingLotRepository;
import Repository.ParkingSlotRepository;
import Repository.TicketRepository;
import Service.strategy.InitServiceImpl;
import constants.VehicleType;
import Service.strategy.InitService;

public class ParkingLotMain {
	public static void main(String[] arg) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException
	{
		ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
		ParkingFloorRepository parkingFloorRepository=new ParkingFloorRepository();
		ParkingSlotRepository parkingSlotRepository=new ParkingSlotRepository();
		GateRepository gateRepository=new GateRepository();
		TicketRepository ticketRepository=new TicketRepository();
		
		
		InitService initService=new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
		initService.init();
		TicketController ticketController=new TicketController(parkingLotRepository, gateRepository, ticketRepository);
		ParkingLot parkingLot=parkingLotRepository.get(1);
		TicketRequestDTO ticketRequestDTO=new TicketRequestDTO();
		ticketRequestDTO.setParkingLotId(1);
		ticketRequestDTO.setGateId(31);
		ticketRequestDTO.setColor("BLUE");
		ticketRequestDTO.setNumber("1234");
		ticketRequestDTO.setName("Mercedez");
		ticketRequestDTO.setVehicleType(VehicleType.CAR);
		
		
		TicketResponseDTO ticketResponseDTO=ticketController.createTicket(ticketRequestDTO);
		System.out.println(ticketResponseDTO);
	}

}
