package Service.strategy.billCalculationStrategy;

public class BillCalculationStrategyFactory {
	//add enum for different strategies, keep it as param and add switch case
	public static BillCalculationStrategy getBillCalculationStrategy() {
		return new LowBillCalculationStrategy();
	}

}
