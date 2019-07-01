package pojo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dbOperation.DatabaseOperations;

@ManagedBean
@SessionScoped
public class User implements java.io.Serializable {

	private int id;
	private String name;
	private String department;
	private List<User> studentList;	
	public static DatabaseOperations dbObj;
	private static final long serialVersionUID = 1L;

	public User() { }

	public User(int id) {
		this.id = id;
	}

	public User(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<User> studentList) {
		this.studentList = studentList;
	}

	// Method To Add New Student Details In Database
	public void saveStudentRecord() {
		System.out.println("Calling saveStudentRecord() Method To Save Student Record");
		dbObj = new DatabaseOperations();
		dbObj.addStudentInDb(this);
	}

	// Method To Delete A Particular Student Record From The Database
	public void deleteStudentRecord() {
		System.out.println("Calling deleteStudentRecord() Method To Delete Student Record");
		dbObj = new DatabaseOperations();
		dbObj.deleteStudentInDb(id);
	}

	// Method To Fetch Particular Student Details From The Database
	public List<User> getStudentDetailsById() {
		System.out.println("Calling getStudentDetailsById() Method Details For Student Id?= " + id);
		dbObj = new DatabaseOperations();		
		studentList = dbObj.getStudentById(id);
		for(User selectedStud : studentList) {
			name = selectedStud.getName();
			department = selectedStud.getDepartment();
		}
		System.out.println("Fetched Id? " + id + " Details Are: Name=" + name + ", Department=" + department);
		return studentList;
	}

	// Method To Update Particular Student Details In Database
	public void updateStudentDetails() {
		System.out.println("Calling updateStudentDetails() Method To Update Student Record");
		dbObj = new DatabaseOperations();		
		dbObj.updateStudentRecord(this);
	}

	// Method To Fetch All Recrods From The Database
	public List<User> getAllStudentRecords() {
		System.out.println("Calling getAllStudentRecords() Method To Fetch Students Record");
		dbObj = new DatabaseOperations();		
		List<User> studentsList = dbObj.retrieveStudent();
		for(User stud : studentsList) {
			if(stud.getId() == id) {
				name = stud.getName();
				department = stud.getDepartment();
			}
		}
		return studentsList;
	}
}