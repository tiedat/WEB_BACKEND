package hotel.employee.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "receiption")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codeStaff;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private LocalDate dob;
    private String phoneNumber;
    private String personalId;
    private String address;
    private String email;
    private String gender;

    public Employee() {
    }

    public Employee(String name, String codeStaff,
                    Department department,
                    LocalDate dob, String phoneNumber,
                    String personalId, String address,
                    String email, String gender) {
        this.name = name;
        this.codeStaff = codeStaff;
        this.department = department;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.personalId = personalId;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeStaff() {
        return codeStaff;
    }

    public void setCodeStaff(String codeStaff) {
        this.codeStaff = codeStaff;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        String codeStaff = employee.getCodeStaff();
        String name = employee.getName();
        LocalDate dob = employee.getDob();
        String gender = employee.getGender();
        String phoneNumber = employee.getPhoneNumber();
        String personId = employee.getPersonalId();
        String email = employee.getEmail();
        String address = employee.getAddress();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codeStaff", "codeStaff.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalId", "personalId.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.empty");

        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }

        if (!email.matches("(^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(.[A-Za-z0-9]+)$)")) {
            errors.rejectValue("email", "email.matches");
        }

        if (name.length() > 30 || name.length() < 2) {
            errors.rejectValue("name", "name.size");
        }
    }
}
