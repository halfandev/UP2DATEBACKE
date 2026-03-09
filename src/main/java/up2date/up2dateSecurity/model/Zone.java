package up2date.up2dateSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "zone_")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneId;
    private String zoneName;
}
