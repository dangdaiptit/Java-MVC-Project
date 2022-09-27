package studentmanager.controller;

import studentmanager.model.StudentDAO;
import studentmanager.model.ValidationStudent;
import studentmanager.model.dto.StudentDTO;
import studentmanager.view.SuccessView;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {



    //get all list student from database
    public static void listAllStudent() {
        System.out.printf("%-10s%-20s%-10s%-10s\n", "IDS", "Name", "Semester", "CourseName");
        StudentDAO.getAllStudent();
    }


    //Create new student
    public static void insertStudent() throws SQLException, ClassNotFoundException {

        System.out.print("Enter id: ");
        String id = ValidationController.checkInputString();
        String name = null;
        boolean checkIdExist = false;
        if (ValidationStudent.checkIdExist(id)) {
            System.err.println("Id already exists. Please re-input.");
            System.out.println("Do you want to continue (Y/N)?");
            if (ValidationController.checkInputYN()) {
                name = ValidationStudent.getNameByID(id);
                System.out.println("NameStudent by Id: " + id + " is: " + name);
                checkIdExist = true;
            } else return;
        }
        if (!checkIdExist) {
            System.out.print("Enter name student: ");
            name = ValidationController.checkInputString();
        }

        System.out.print("Enter semester: ");
        String semester = ValidationController.checkInputString();
        System.out.print("Enter name course: ");
        String course = ValidationController.checkInputCourse();

        StudentDTO studentDTO = new StudentDTO(id, name, semester, course);

        if (ValidationStudent.checkExistStudent(studentDTO)) {
            StudentDAO.addStudent(studentDTO);
            System.out.println("Insert student success!");
        } else {
            System.out.println("Student exits!");
        }

    }


    //Find student by name
    public static void findStudentByName() throws SQLException, ClassNotFoundException {

        System.out.print("Enter name student: ");
        String name = ValidationController.checkInputString();

        if (ValidationStudent.checkExistStudentByName(name)) {
            System.out.printf("%-10s%-20s%-10s%-10s\n", "IDS", "Name", "Semester", "CourseName");
            StudentDAO.findAndSortByName(name);
            System.out.println("Find and Sort success!");
        } else {
            System.out.println("No found student");
        }

    }

    //Update and Delete Student

    public static void updateAndDelete() throws SQLException, ClassNotFoundException {
        System.out.print("Enter IDS student: ");
        String ids = ValidationController.checkInputString();
        if (ValidationStudent.checkIdExist(ids)) {
            System.out.printf("%-10s%-10s%-20s%-10s%-10s\n", "ID", "IDS", "Name", "Semester", "CourseName");
            StudentDAO.getListStudentById(ids);
            System.out.print("Do you want Update (U) or Delete (D) student: ");
            if (ValidationController.checkInputUD()) {
                System.out.print("Enter ID student want update: ");
                int id = ValidationController.checkInputInteger();
                System.out.print("Enter name: ");
                String name = ValidationController.checkInputString();
                System.out.print("Enter semester: ");
                String semester = ValidationController.checkInputString();
                System.out.print("Enter course: ");
                String course = ValidationController.checkInputCourse();

                if (!ValidationStudent.checkStudentExistAfterUD(ids, semester, course)) {
                    StudentDAO.updateStudent(id, name, semester, course);
                    StudentDAO.replaceAllNameById(ids, name);
                    System.out.println("Update success!");
                } else System.out.println("Exist student!");

            } else {
                System.out.print("Enter ID student want delete: ");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                StudentDAO.deleteStudent(id);
                System.out.println("Delete student success!");
            }
        } else System.out.println("No found student!");
    }


}
