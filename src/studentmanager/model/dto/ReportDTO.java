package studentmanager.model.dto;

public class ReportDTO {
    private String studentId;
    private String studentName;
    private String courseName;
    private String totalCourse;

    public ReportDTO(String studentId, String studentName, String courseName, String totalCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(String totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return "ReportDTO{" + "studentId='" + studentId + '\'' + ", studentName='" + studentName + '\'' + ", courseName='" + courseName + '\'' + ", totalCourse='" + totalCourse + '\'' + '}';
    }
}
