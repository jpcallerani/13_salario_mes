package entities;

import java.util.Calendar;
import java.util.List;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Departament departament;
	private List<HourContract> hourContracts;

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, List<HourContract> hourContracts) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.hourContracts = hourContracts;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getHourContracts() {
		return hourContracts;
	}

	public void setHourContracts(List<HourContract> hourContracts) {
		this.hourContracts = hourContracts;
	}

	/**
	 * 
	 * @param contract
	 */
	public void addContract(HourContract contract) {

	}

	/**
	 * 
	 * @param contract
	 */
	public void removeContract(HourContract contract) {

	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public Double income(Integer year, Integer month) {
		Double income = 0.0;
		for (HourContract hourContract : hourContracts) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hourContract.getDate());
			if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month) {
				income = hourContract.totalValue();
			}
		}
		return income;
	}
}
