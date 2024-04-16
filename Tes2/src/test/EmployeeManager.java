package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

 class EmployeeManager {
    private List<Employee> employees = new ArrayList<Employee>();

    /*
    public abstract void addEmployee(Employee emp);
    public abstract boolean removeEmployee(String ID);
    public abstract void updateEmployee(String ID, Employee newEmp);
    public abstract Employee findEmployee(String ID);
    public abstract void showAllEmployees();
    public abstract void writeEmployeesToFile(String fileName);
    public abstract void readEmployeesFromFile(String fileName);
	*/
  
    public void addEmployee(Employee emp) {
        if (emp != null) {
        	employees.add((Experience) emp);
        } else {
            System.out.println("Invalid employee type.");
        }
    }

   
    public boolean removeEmployee(String ID) {
        for (Employee emp : employees) {
            if (emp.ID.equals(ID)) {
            	employees.remove(emp);
                return true;
            }
        }
        return false;
    }

    public void writeEmployeesToFile(String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employees);
            System.out.println("Danh sách nhân viên đã được ghi vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readEmployeesFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> readEmployees = (List<Employee>) in.readObject();
            System.out.println("Danh sách nhân viên đã được đọc từ file " + fileName);
            employees.clear();
            employees.addAll(readEmployees);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


	public void updateEmployee(String ID, Employee newEmp) {
		int i = 0 ; 
		for (Employee employee : employees) {
            if (employee.getID().equals(ID)) {
            	employees.set(i, newEmp) ; 
            }
            i ++ ; 
        }
    }


	public Employee findEmployee(String ID) {
		for (Employee emp : employees) {
            if (emp.ID.equals(ID)) {
                return emp;
            }
        }
        return null;
	}

	public void showAllEmployees() {
		 for (Employee emp : employees) {
	            emp.showInfo();
	     }
	}
}

