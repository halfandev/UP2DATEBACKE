package up2date.up2dateSecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wardId;
    private String wardName;
}
