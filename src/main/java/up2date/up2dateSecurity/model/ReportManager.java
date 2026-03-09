package up2date.up2dateSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "report_manager")
public class ReportManager {
    @Id
    private Long managerId;
    private String firstName;
    private String middleName;
    private String lastname;

}
