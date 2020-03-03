package hotel.staff.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column( unique = true)
    private String name;

    @OneToMany(targetEntity = Staff.class, fetch = FetchType.EAGER)
    private List<Staff> staffList;

    public Department() {
    }

    public Department(@NotBlank String name, List<Staff> staffList) {
        this.name = name;
        this.staffList = staffList;
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

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
