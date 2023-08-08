package emp;

abstract class Employee {
	private String name;
	private int number;
	private String department;
	private int salary;
	
	Employee(){}
	Employee(String name, int number, String department, int salary){
		this.name = name;
		this.number = number;
		this.department = department;
		this.setSalary(salary);
	}
	
	abstract double tax();
	
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public String getDepartment() {
		return department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}

interface Bonus{
	abstract void incentive(int pay);
}

class Secretary extends Employee implements Bonus{
	Secretary(){}
	Secretary(String name, int number, String department, int salary){
		super(name, number, department, salary);
	}
	@Override
	public void incentive(int pay) {
		setSalary((int) (getSalary() + (pay*0.8)));
		
	}
	@Override
	double tax() {
		return getSalary() * 0.1;
	}
	
}

class Sales extends Employee implements Bonus{
	Sales(){}
	Sales(String name, int number, String department, int salary){
		super(name, number, department, salary);
	}
	@Override
	public void incentive(int pay) {
		setSalary((int) (getSalary() + (pay*1.2)));
		
	}
	@Override
	double tax() {
		return getSalary() * 0.13;
	}
	double getExtraPay() {
		return getSalary() * 0.03;
	}
	
}
public class Company {

	public static void main(String[] args) {
		Employee[] emp = new Employee[]{
				new Secretary("Duke", 1, "secretary", 800),
				new Sales("Tuxi", 2, "sales", 1200)
				};
		
		System.out.println("name \tdepartment \tsalary \textra pay");
		System.out.println("-------------------------------------");
		printEmployee(emp, false);
		
		System.out.println();
		System.out.println("[인센티브 100 지급]");
		System.out.println("name \tdepartment \tsalary \ttax \textra pay");
		System.out.println("--------------------------------------------------");
		for (Employee ep: emp) {
//			if(ep instanceof Sales) {
//				((Sales) ep).incentive(100);
//			} else {
//				((Secretary) ep).incentive(100);
//			}
			((Bonus) ep).incentive(100);
		}

		printEmployee(emp, true);
		
	}

	static void printEmployee(Employee[] emp, boolean isTax) {
		
		for (Employee ep : emp) {
			//System.out.print(ep.tax());
			System.out.print(ep.getName() + " \t" + ep.getDepartment() + "       " + ep.getSalary() + " \t");
			if (isTax == true) {
				System.out.print(ep.tax() + "\t");
			}
			if (ep instanceof Sales) {
				System.out.println( ((Sales) ep).getExtraPay());
			} else {
				System.out.println();
			}
		}
		
	}
}
