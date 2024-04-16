package test;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static EmployeeManager em = new EmployeeManager() ;
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
        	menu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    Employee e = inputInforEmployee(scanner);
                    em.addEmployee(e);
                    break;
                case 2:
                    System.out.print("Nhập ID của nhân viên cần cập nhật: ");
                    String updateID = scanner.nextLine();
                    Employee tmp_eml = em.findEmployee(updateID);
                    if (tmp_eml != null) {
                        Employee new_eml = inputInforEmployee(scanner);
                        em.updateEmployee(updateID, new_eml);
                    } else {
                        System.out.println("Không tìm thấy nhân viên có ID " + updateID);
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID của nhân viên cần xóa: ");
                    String removeID = scanner.nextLine();
                    boolean removed = em.removeEmployee(removeID);
                    if (removed) {
                        System.out.println("Nhân viên có ID " + removeID + " đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy nhân viên có ID " + removeID);
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID của nhân viên cần tìm: ");
                    String searchID = scanner.nextLine();
                    Employee searchedEmployee = em.findEmployee(searchID);
                    if (searchedEmployee != null) {
                        System.out.println("Thông tin của nhân viên:");
                        searchedEmployee.showInfo();
                    } else {
                        System.out.println("Không tìm thấy nhân viên có ID " + searchID);
                    }
                    break;
                case 5:
                    em.showAllEmployees();
                    break;
                case 6: 
                	System.out.println("Nhập đường dẫn đến file: ");
                	String fileName = scanner.nextLine() ;
                	em.writeEmployeesToFile(fileName);
                	break;
                case 7:
                	System.out.println("Nhập đường dẫn đến file: ");
                	String fileName1 = scanner.nextLine() ;
                	em.readEmployeesFromFile(fileName1);
                	em.showAllEmployees();
                	break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    break ;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }
    }
    
    public static void menu() {
    	System.out.println("------------MENU-----------");
        System.out.println("Chọn chức năng:");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Cập nhật nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Tìm kiếm nhân viên");
        System.out.println("5. Hiển thị thông tin nhân viên");
        System.out.println("6. Ghi danh sách nhân viên vào file.");
        System.out.println("7. Đọc danh sách nhân viên từ file.");
        System.out.print("Nhập lựa chọn của bạn: ");
    }
    
    public static BasicInformation inputBasicInfomation(Scanner scanner) {
    	System.out.print("Nhập ID: ");
        String ID = scanner.nextLine();
        System.out.print("Nhập Họ và Tên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập Ngày Sinh: ");
        String birthDay = scanner.nextLine();
        System.out.print("Nhập Số Điện Thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();
    	BasicInformation bi = new BasicInformation(ID, fullName, birthDay, phone, email);
    	return bi ; 
    }
    
    public static Employee inputInforEmployee (Scanner scanner) {
    	System.out.println("Nhập loại nhân viên (1. Experience, 2. Fresher, 3. Intern): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        BasicInformation bi = inputBasicInfomation(scanner) ; 
        switch (type) {
            case 1: // Experience 
                System.out.print("Nhập Số Năm Kinh Nghiệm: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Nhập Kỹ Năng Chuyên Môn: ");
                String proSkill = scanner.nextLine();
                Experience experience = new Experience(bi.getID(), bi.getFullName(), bi.getBirthDay(), bi.getPhone(), bi.getEmail(), expInYear, proSkill) ;
                return experience;
            case 2: // 
                 System.out.print("Nhập Ngày Tốt Nghiệp: ");
                 String graduationDate = scanner.nextLine();
                 System.out.print("Nhập Xếp Loại Tốt Nghiệp: ");
                 String graduationRank = scanner.nextLine();
                 System.out.print("Nhập Trường Đào Tạo: ");
                 String education = scanner.nextLine();
                 Fresher fresher = new Fresher(bi.getID(), bi.getFullName(), bi.getBirthDay(), bi.getPhone(), bi.getEmail(), graduationDate, graduationRank, education);
                 return fresher;
            case 3:
                System.out.print("Nhập chuyên ngành đang học: ");
                String majors = scanner.nextLine();
                System.out.print("Nhập học kì đang học: ");
                String semester = scanner.nextLine();
                System.out.print("Nhập tên trường đang học: ");
                String universityName = scanner.nextLine();
                Intern i = new Intern(bi.getID(), bi.getFullName(), bi.getBirthDay(), bi.getPhone(), bi.getEmail(), majors, semester, universityName);
                return i ; 
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return null ; 
        }
    }
}
