package Service.strategy.billCalculationStrategy;

import java.time.LocalDateTime;

import Models.Ticket;

public interface BillCalculationStrategy {
	
	double calculationBillAmount(Ticket ticket, LocalDateTime exitTime);

}
