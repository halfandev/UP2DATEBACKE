package up2date.up2dateSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "employee_")
public class Employee {

    @Id
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private LocalDate dateOfBirth;
    private String regionName;
    private String districtName;
    private String wardName;
    private Integer nidaNumber;
    private String email;
    private Integer phoneNumber;
    private String emergenceName;
    private Integer secondNumber;
    private String address;
    private LocalDate doe;
    @ManyToOne
    private Zone zone;

    @ManyToOne
    private PlaceWorking working;

    private String jobTitle;
    @ManyToOne
    private ReportManager reportManager;

    @Lob
    private byte[] photo;

    @Lob
    private byte[] applicationLetter;

    @Lob
    private byte[] chairmanLetter;

}
