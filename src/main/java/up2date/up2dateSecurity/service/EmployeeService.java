package up2date.up2dateSecurity.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import up2date.up2dateSecurity.model.Employee;

import up2date.up2dateSecurity.model.PlaceWorking;
import up2date.up2dateSecurity.model.ReportManager;
import up2date.up2dateSecurity.model.Zone;
import up2date.up2dateSecurity.repository.EmployeeRepository;
import up2date.up2dateSecurity.repository.PlaceWorkingRepository;
import up2date.up2dateSecurity.repository.ReportManagerRepository;
import up2date.up2dateSecurity.repository.ZoneRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ZoneRepository zoneRepository;
    private final PlaceWorkingRepository placeWorkingRepository;
    private final ReportManagerRepository reportManagerRepository;

    public Employee createEmployee(
            Long employeeId, String firstName, String middleName, String lastName, String gender, String maritalStatus,
            LocalDate dateOfBirth, String regionName, String districtName, String wardName, Integer nidaNumber,
            String email, Integer phoneNumber, String emergenceName, Integer secondNumber, String address, LocalDate doe,
            Integer zoneId, Integer placeId, Long managerId,
            MultipartFile photo, MultipartFile applicationLetter, MultipartFile chairmanLetter
    ) throws IOException {

        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        emp.setFirstName(firstName);
        emp.setMiddleName(middleName);
        emp.setLastName(lastName);
        emp.setGender(gender);
        emp.setMaritalStatus(maritalStatus);
        emp.setDateOfBirth(dateOfBirth);
        emp.setRegionName(regionName);
        emp.setDistrictName(districtName);
        emp.setWardName(wardName);
        emp.setNidaNumber(nidaNumber);
        emp.setEmail(email);
        emp.setPhoneNumber(phoneNumber);
        emp.setEmergenceName(emergenceName);
        emp.setSecondNumber(secondNumber);
        emp.setAddress(address);
        emp.setDoe(doe);

        // resolve ManyToOne
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
        emp.setZone(zone);

        PlaceWorking working = placeWorkingRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Working place not found"));
        emp.setWorking(working);

        ReportManager manager = reportManagerRepository.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Report Manager not found"));
        emp.setReportManager(manager);

        if (photo != null && !photo.isEmpty()) {
            emp.setPhoto(photo.getBytes());
        }
        if (applicationLetter != null && !applicationLetter.isEmpty()) {
            emp.setApplicationLetter(applicationLetter.getBytes());
        }
        if (chairmanLetter != null && !chairmanLetter.isEmpty()) {
            emp.setChairmanLetter(chairmanLetter.getBytes());
        }

        return employeeRepository.save(emp);
    }

    // GET all
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET by ID
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    // GET by NIDA number
    public Optional<Employee> getEmployeeByNidaNumber(Integer nidaNumber) {
        return employeeRepository.findByNidaNumber(nidaNumber);
    }

    // DELETE by ID
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    public Employee updateEmployee(
            Long id, String firstName, String middleName, String lastName, String gender, String maritalStatus,
            LocalDate dateOfBirth, String regionName, String districtName, String wardName, Integer nidaNumber,
            String email, Integer phoneNumber, String emergenceName, Integer secondNumber, String address,
             LocalDate doe, String jobTitle,
            Integer zoneId, Integer placeId, Long managerId,
            MultipartFile photo, MultipartFile applicationLetter, MultipartFile chairmanLetter
    ) throws IOException {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setFirstName(firstName);
        emp.setMiddleName(middleName);
        emp.setLastName(lastName);
        emp.setGender(gender);
        emp.setMaritalStatus(maritalStatus);
        emp.setDateOfBirth(dateOfBirth);
        emp.setRegionName(regionName);
        emp.setDistrictName(districtName);
        emp.setWardName(wardName);
        emp.setNidaNumber(nidaNumber);
        emp.setEmail(email);
        emp.setPhoneNumber(phoneNumber);
        emp.setEmergenceName(emergenceName);
        emp.setSecondNumber(secondNumber);
        emp.setAddress(address);
        emp.setDoe(doe);
        emp.setJobTitle(jobTitle);

        // resolve ManyToOne
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
        emp.setZone(zone);

        PlaceWorking working = placeWorkingRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Working place not found"));
        emp.setWorking(working);

        ReportManager manager = reportManagerRepository.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Report Manager not found"));
        emp.setReportManager(manager);

        if (photo != null && !photo.isEmpty()) {
            emp.setPhoto(photo.getBytes());
        }
        if (applicationLetter != null && !applicationLetter.isEmpty()) {
            emp.setApplicationLetter(applicationLetter.getBytes());
        }
        if (chairmanLetter != null && !chairmanLetter.isEmpty()) {
            emp.setChairmanLetter(chairmanLetter.getBytes());
        }

        return employeeRepository.save(emp);
    }

}
