package studentmanager.controller;

import studentmanager.model.ReportDAO;

import java.sql.SQLException;

public class ReportController {

    public static void listReportStudent() throws SQLException, ClassNotFoundException {
        System.out.printf("%-10s%-20s%-10s%-10s\n", "IDS", "Name", "Course", "Total");
        ReportDAO.getReportByCourse();
    }
}
