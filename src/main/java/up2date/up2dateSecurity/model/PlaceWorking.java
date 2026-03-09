package up2date.up2dateSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "place_working")
public class PlaceWorking {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer placeId;
    private String placeName;
}
