package studentmanager.model;

import studentmanager.model.dto.StudentDTO;
import studentmanager.model.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidationStudent {

    public static boolean checkExistStudent(StudentDTO newStudent) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT COUNT(*) as indexs FROM students WHERE student_id = ? " + "and student_name = ? and semester = ? and course_name = ?");
            pstmt.setString(1, newStudent.getId());
            pstmt.setString(2, newStudent.getStudentName());
            pstmt.setString(3, newStudent.getSemester());
            pstmt.setString(4, newStudent.getCourseName());

            resultSet = pstmt.executeQuery();
            int index = 0;
            while (resultSet.next()) {
                index = resultSet.getInt("indexs");
                System.out.println("res: " + index);
            }

            if (index == 0) {
                return true;
            }

        } finally {
            DBUtil.close(conn, pstmt, resultSet);

        }
        return false;
    }

    public static boolean checkExistStudentByName(String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT COUNT(*) as indexs FROM students WHERE student_name LIKE ?");
            pstmt.setString(1, "%" + name + "%");
            res = pstmt.executeQuery();

            int index = 0;
            while (res.next()) {
                index = res.getInt("indexs");
                System.out.println("index = " + index);
            }

            if (index != 0) {
                return true;
            }

        } finally {
            DBUtil.close(conn, pstmt, res);
        }
        return false;
    }

    public static String getNameByID(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String name = null;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT * FROM dbo.students WHERE student_id = ?");
            pstmt.setString(1, id);

            rset = pstmt.executeQuery();
            while (rset.next()) {
                name = rset.getString(3);
                break;
            }

        } finally {
            DBUtil.close(conn, pstmt, rset);
        }
        return name;
    }

    //check ID student exist or not. If exist return true else return false
    public static boolean checkIdExist(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT COUNT(*) as indexs FROM students WHERE student_id = ?");
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();
            int index = 0;
            while (rset.next()) {
                index = rset.getInt("indexs");
            }

            if (index > 0) {
                return true;
            }

        } finally {
            DBUtil.close(conn, pstmt, rset);
        }
        return false;

    }


    //check student exist or not. If exist return true else return false
    public static boolean checkStudentExistAfterUD(String ids, String semester, String course) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT COUNT(*) indexs  FROM students WHERE student_id = ? " +
                    "and semester = ? and course_name = ?");
            pstmt.setString(1, ids);
            pstmt.setString(2, semester);
            pstmt.setString(3, course);
            rset = pstmt.executeQuery();
            int index = 0;
            while (rset.next()) {
                index = rset.getInt("indexs");
            }

            if (index > 0) {
                return true;
            }

        } finally {
            DBUtil.close(conn, pstmt, rset);
        }
        return false;

    }




}
