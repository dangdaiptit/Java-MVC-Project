package studentmanager.model;

import studentmanager.model.dto.StudentDTO;
import studentmanager.model.util.DBUtil;
import studentmanager.view.SuccessView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDAO {

    //get All student from database
    public static void getAllStudent() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        StudentDTO studentDTO;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT * FROM dbo.students ORDER BY student_id");

            rset = pstmt.executeQuery();

            while (rset.next()) {
                studentDTO = new StudentDTO(rset.getString(2), rset.getString(3),
                        rset.getString(4), rset.getString(5));
                SuccessView.allListStudentView(studentDTO);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, pstmt, rset);
        }

    }

    //add student from database
    public static void addStudent(StudentDTO newStudent) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("INSERT INTO students VALUES (?,?,?,?)");

            pstmt.setString(1, newStudent.getId());
            pstmt.setString(2, newStudent.getStudentName());
            pstmt.setString(3, newStudent.getSemester());
            pstmt.setString(4, newStudent.getCourseName());

            pstmt.executeUpdate();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, pstmt);
        }

    }


    public static void findAndSortByName(String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        StudentDTO studentDTO;
        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT * FROM students WHERE student_name LIKE ? ORDER BY student_name");
            pstmt.setString(1, "%" + name + "%");
            res = pstmt.executeQuery();

            while (res.next()) {
                studentDTO = new StudentDTO(res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                SuccessView.getListStudentByName(studentDTO);
            }


        } finally {
            DBUtil.close(conn, pstmt, res);
        }
    }


    public static void getListStudentById(String ids) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        StudentDTO studentDTO;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("SELECT * FROM students WHERE student_id = ?");
            pstmt.setString(1, ids);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                studentDTO = new StudentDTO(rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
                int index = rset.getInt(1);
                SuccessView.getListStudentById(studentDTO, index);
            }
        } finally {
            DBUtil.close(conn, pstmt, rset);
        }
    }

    //update student by ID from database
    public static void updateStudent(int id, String name, String semester, String course) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("UPDATE students\n" + "SET student_name = ?, semester = ?, course_name = ?\n" + "WHERE id = ?;");
            pstmt.setString(1, name);
            pstmt.setString(2, semester);
            pstmt.setString(3, course);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } finally {
            DBUtil.close(conn, pstmt);
        }
    }

    //delete student by ID from database
    public static void deleteStudent(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("DELETE FROM students WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }


    //replace all nameStudent by ID from database
    public static void replaceAllNameById(String ids, String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnect();
            pstmt = conn.prepareStatement("UPDATE students SET student_name = ? WHERE student_id = ?");
            pstmt.setString(1, name);
            pstmt.setString(2, ids);
            pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }





}
