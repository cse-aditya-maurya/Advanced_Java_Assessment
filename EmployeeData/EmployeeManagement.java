import java.util.*;
import java.util.stream.Collectors;

class  EmployeeManagement {
 public double averageSalary(List<Employee> list1) {
 	 // return list1.stream()
     //    .collect(Collectors.averagingDouble(Employee::getSalary));

 	return list1.stream()
        .mapToDouble(Employee::getSalary)
        .average()
        .orElse(0.0);

 } 

// i)method
 public double getMaxSalary(List<Employee> list1) {
    return list1.stream()
            .mapToDouble(Employee::getSalary)
            .max()
            .orElse(0.0);

}

// ii)
 public Employee getMaxSalary1(List<Employee> list1) {
    return list1.stream()
            .max(Comparator.comparingDouble(Employee::getSalary))
            .orElse(null);
}
 
  public List<Employee> getEmployeeSalaryAbove(List<Employee> list1){
   return list1.stream().filter(e->e.getSalary()>80000)
                         .collect(Collectors.toList());
  }

  public Map<String,Long> getEachDepartmentEmployeeCount(List<Employee> list1){
    return list1.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.counting()));
  }

 public List<Employee> getItDepartmentExp(List<Employee> list1) {
    return list1.stream()
            .filter(e -> e.getYearsOfExperience() > 5 &&
                         "IT".equals(e.getDepartment()))
            .collect(Collectors.toList());
}





    

}