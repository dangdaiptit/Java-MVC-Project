package studentmanager.view;

import studentmanager.controller.ReportController;
import studentmanager.controller.StudentController;
import studentmanager.controller.ValidationController;


import java.sql.SQLException;

public class StartView {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        while (true) {
            SuccessView.menu();
            int choice = ValidationController.checkInputLimit(1, 6);
            switch (choice) {
                case 1:
                    StudentController.insertStudent();
                    break;
                case 2:
                    StudentController.findStudentByName();
                    break;
                case 3:
                    StudentController.updateAndDelete();
                    break;
                case 4:
                    ReportController.listReportStudent();
                    break;
                case 5:
                    StudentController.listAllStudent();
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
            }
        }

    }
}
