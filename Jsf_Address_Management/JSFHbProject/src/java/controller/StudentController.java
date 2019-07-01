package controller;

import entities.Student;
import java.util.List;
import javax.faces.bean.ManagedBean;
import serviceImp.StudentServiceImp;



@ManagedBean
public class StudentController {
    
    private Student student;
    private List<Student> students;
    private StudentServiceImp studentService = new StudentServiceImp();;
    
    public void save(){
        studentService.save(student);
        System.out.println("Student saved");
    }
    
    public Student getStudent() {
        
        if(student == null){
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        students = studentService.getStudentList();
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
