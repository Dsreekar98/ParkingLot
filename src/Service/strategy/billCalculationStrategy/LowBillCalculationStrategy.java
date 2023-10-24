package Service.strategy.billCalculationStrategy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import Models.Ticket;
import constants.VehicleType;

public class LowBillCalculationStrategy implements BillCalculationStrategy {

	private static final int PER_HOUR_2_WHEELER = 50;
	private static final int PER_HOUR_4_WHEELER = 100;
	private static final double INCREMENT_FACTOR=0.1;
	
	/*
	 * 1st hour -> 50
	 * 2nd hour -> 50 * 2 + (0.1 * 2-1) =>10 =>110
	 * 3rd hour -> 50*3 => 150 | 150 * (0.1 * 3-1) => 150 * 0.2 =>30 -> 180
	 * formula = base cost=> fixedCost * N 
	 * totalCost = baseCost +baseCost * [incrementFactor * [N-1]]
	 * 
	 */
	@Override
	public double calculationBillAmount(Ticket ticket, LocalDateTime exitTime) {
		LocalDateTime entryTme = ticket.getEntryTime();
		long totalHours = ChronoUnit.HOURS.between(exitTime, entryTme);
		int costPerHour = (ticket.getVehicle().getVehicleType().equals(VehicleType.CAR)) ? PER_HOUR_4_WHEELER
				: PER_HOUR_2_WHEELER;
		double baseCost=costPerHour*totalHours;
		return baseCost+ (baseCost*(INCREMENT_FACTOR*(totalHours-1)));
	}

}
