package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

public class exercicio13 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		// ------------------------------------------
		Date mesAno;
		Integer qtdeContract = 0;
		HourContract contract;
		Worker worker = new Worker();
		Departament departamento = new Departament();
		List<HourContract> hourContracts = new ArrayList<>();
		// ------------------------------------------
		System.out.println("Entre com o nome do departamento: ");
		departamento.setName(in.nextLine());
		worker.setDepartament(departamento);
		// ------------------------------------------
		System.out.println("Entre com o nome do trabalhador: ");
		worker.setName(in.nextLine());
		// ------------------------------------------
		System.out.println("Entre com o level do trabalhador: ");
		worker.setLevel(WorkerLevel.valueOf(in.nextLine()));
		// ------------------------------------------
		System.out.println("Entre com o salário base: ");
		worker.setBaseSalary(in.nextDouble());
		// ------------------------------------------
		System.out.println("Qual a quantidade de contratos?");
		qtdeContract = in.nextInt();
		for (int i = 0; i < qtdeContract; i++) {
			contract = new HourContract();
			System.out.println("Entre com a informação do #" + i+1 + "º contrato");
			// ------------------------------------------
			in.nextLine();
			System.out.println("Data (DD/MM/YYYY): ");
			contract.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine()));
			// ------------------------------------------
			System.out.println("Valor por hora: ");
			contract.setValuePerHour(in.nextDouble());
			// ------------------------------------------
			System.out.println("Duração (horas): ");
			contract.setHours(in.nextInt());
			hourContracts.add(contract);
			// ------------------------------------------
		}
		// ------------------------------------------
		worker.setHourContracts(hourContracts);
		in.nextInt();
		// ------------------------------------------
		System.out.println("Entre com o mês e o ano para calcular o total: ");
		mesAno = new SimpleDateFormat("MM/yyyy").parse(in.nextLine());
		// ------------------------------------------
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartament().getName());
		System.out.println("Total para " + mesAno + ": " + worker.income(mesAno.getMonth(), mesAno.getYear()));
	}

}
