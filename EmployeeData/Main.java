import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		   List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT", "Dev", 90000, 6),
            new Employee(2, "Bob", "HR", "Manager", 70000, 8),
            new Employee(3, "Charlie", "IT", "Tester", 85000, 4),
            new Employee(4, "David", "Finance", "Analyst", 100000, 9),
            new Employee(5, "Eva", "IT", "Architect", 120000, 10)
        );
		EmployeeManagement em = new EmployeeManagement();
	System.out.println("Average Salary: " + em.averageSalary(employees));
    System.out.println("Average Salary: " + em.getMaxSalary(employees));
       Employee maxEmp = em.getMaxSalary1(employees);

    if (maxEmp != null) {
            System.out.println("Employee with max salary:");
            System.out.println("Name: " + maxEmp.getName());
            System.out.println("Salary: " + maxEmp.getSalary());
        } else {
            System.out.println("Employee list is empty.");
        }

        List<Employee> highearnes=em.getEmployeeSalaryAbove(employees);
        System.out.println("Employee salary above 80000");;
        highearnes.forEach(e-> System.out.println("Name: "+e.getName()+" salary: "+e.getSalary()));
      
       List<Employee> itDepart=em.getItDepartmentExp(employees);
       System.out.println("Employee with It department exp more than 5 year");
       itDepart.forEach(e->System.out.println("Department: "+e.getDepartment()+", Year of exp: "+e.getYearsOfExperience()));

       Map<String,Long> count=em.getEachDepartmentEmployeeCount(employees);
       System.out.println(count);



	}
}