package studentmanager.model;

import studentmanager.model.dto.ReportDTO;
import studentmanager.model.util.DBUtil;
import studentmanager.view.SuccessView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDAO {

    //Get list Report Student by Course
    public static void getReportByCourse() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ReportDTO reportDTO;
        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT student_id,student_name, course_name, COUNT(*) Total FROM students " +
                    "GROUP BY  student_id,student_name, course_name ORDER BY student_id");
            rset = pstmt.executeQuery();
            while (rset.next()) {
                reportDTO = new ReportDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
                SuccessView.getListReportStudent(reportDTO);
            }
        } finally {
            DBUtil.close(conn, pstmt, rset);
        }
    }
}
