  public class Employee { 
  	private int employeeId;
    private String name;
    private String department;
    private String designation;
    private double salary;
    private int yearsOfExperience;

        public Employee(int employeeId, String name, String department,
                    String designation, double salary, int yearsOfExperience) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getter and Setter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter and Setter for designation
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter and Setter for yearsOfExperience
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}


