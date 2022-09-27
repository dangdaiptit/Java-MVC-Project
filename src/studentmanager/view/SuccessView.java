package studentmanager.view;

import studentmanager.model.dto.ReportDTO;
import studentmanager.model.dto.StudentDTO;


public class SuccessView {

    //show menu
    public static void menu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Display List Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        System.out.println();
    }

    public static void allListStudentView(StudentDTO studentDTO) {
            System.out.printf("%-10s%-20s%-10s%-10s\n", studentDTO.getId() , studentDTO.getStudentName() , studentDTO.getSemester()
                    ,studentDTO.getCourseName() );
    }

    public static void getListStudentByName(StudentDTO studentDTO) {
        System.out.printf("%-10s%-20s%-10s%-10s\n", studentDTO.getId() , studentDTO.getStudentName() , studentDTO.getSemester()
                ,studentDTO.getCourseName());
    }

    public static void getListStudentById(StudentDTO studentDTO, int id) {
        System.out.printf("%-10d%-10s%-20s%-10s%-10s\n",id, studentDTO.getId() , studentDTO.getStudentName() , studentDTO.getSemester()
                ,studentDTO.getCourseName());
    }

    public static void getListReportStudent(ReportDTO reportDTO) {
        System.out.printf("%-10s%-20s%-10s%-10s\n",reportDTO.getStudentId(), reportDTO.getStudentName(),
                reportDTO.getCourseName(), reportDTO.getTotalCourse());
    }


}
