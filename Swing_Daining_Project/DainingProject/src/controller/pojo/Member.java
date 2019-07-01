package controller.pojo;

import java.util.Date;
import java.util.List;

public class Member {

    private int id;
    private String name;
    private String mobile;
    private String email;
    private String deptName;
    private String regNum;
    private String session;
    private int cardNo;
    private String membershipType;
    private String membershipStaus="inactive";
    private Date creationDate;
    
    private List<String> monthAssigend;
    private List<Integer> offDays;

    public Member(int id, String name, String mobile, String email, String deptName, String regNum, String session, int cardNo, String membershipType, String membershipStaus, Date creationDate) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.deptName = deptName;
        this.regNum = regNum;
        this.session = session;
        this.cardNo = cardNo;
        this.membershipType = membershipType;
        this.membershipStaus = membershipStaus;
        this.creationDate = creationDate;
    }
    
    
    
    public Member(String name, String mobile, String email, String deptName, String regNum, String session, int cardNo, String membershipType, String membershipStaus, Date creationDate) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.deptName = deptName;
        this.regNum = regNum;
        this.session = session;
        this.cardNo = cardNo;
        this.membershipType = membershipType;
        this.membershipStaus = membershipStaus;
        this.creationDate = creationDate;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipStaus() {
        return membershipStaus;
    }

    public void setMembershipStaus(String membershipStaus) {
        this.membershipStaus = membershipStaus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    

    public List<String> getMonthAssigend() {
        return monthAssigend;
    }

    public void setMonthAssigend(List<String> monthAssigend) {
        this.monthAssigend = monthAssigend;
    }

    public List<Integer> getOffDays() {
        return offDays;
    }

    public void setOffDays(List<Integer> offDays) {
        this.offDays = offDays;
    }
    
    
    
    

}
