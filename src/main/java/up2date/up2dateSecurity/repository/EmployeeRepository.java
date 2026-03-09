package up2date.up2dateSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import up2date.up2dateSecurity.model.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByNidaNumber(Integer nidaNumber);
    Optional<Employee> findByPhoneNumber(Integer phoneNumber);
}
