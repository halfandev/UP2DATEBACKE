package up2date.up2dateSecurity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import up2date.up2dateSecurity.model.Employee;
import up2date.up2dateSecurity.service.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Employee> createEmployee(
            @RequestParam("employeeId") Long employeeId,
            @RequestParam("firstName") String firstName,
            @RequestParam(value = "middleName", required = false) String middleName,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") String gender,
            @RequestParam("maritalStatus") String maritalStatus,
            @RequestParam("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
            @RequestParam("regionName") String regionName,
            @RequestParam("districtName") String districtName,
            @RequestParam("wardName") String wardName,
            @RequestParam("nidaNumber") Integer nidaNumber,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") Integer phoneNumber,
            @RequestParam("emergenceName") String emergenceName,
            @RequestParam("secondNumber") Integer secondNumber,
            @RequestParam("address") String address,
            @RequestParam("doe") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate doe,

            // send IDs instead of object
            @RequestParam("zoneId") Integer zoneId,
            @RequestParam("placeId") Integer placeId,
            @RequestParam("managerId") Long managerId,

            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam(value = "applicationLetter", required = false) MultipartFile applicationLetter,
            @RequestParam(value = "chairmanLetter", required = false) MultipartFile chairmanLetter
    ) throws IOException {
        Employee employee = employeeService.createEmployee(
                employeeId, firstName, middleName, lastName, gender, maritalStatus, dateOfBirth,
                regionName, districtName, wardName, nidaNumber, email, phoneNumber, emergenceName,
                secondNumber, address, doe,
                zoneId, placeId, managerId,
                photo, applicationLetter, chairmanLetter
        );
        return ResponseEntity.ok(employee);
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET by ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET by NIDA
    @GetMapping("/nida/{nidaNumber}")
    public ResponseEntity<Employee> getEmployeeByNidaNumber(@PathVariable Integer nidaNumber) {
        return employeeService.getEmployeeByNidaNumber(nidaNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


    // UPDATE
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestParam("firstName") String firstName,
            @RequestParam(value = "middleName", required = false) String middleName,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") String gender,
            @RequestParam("maritalStatus") String maritalStatus,
            @RequestParam("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
            @RequestParam("regionName") String regionName,
            @RequestParam("districtName") String districtName,
            @RequestParam("wardName") String wardName,
            @RequestParam("nidaNumber") Integer nidaNumber,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") Integer phoneNumber,
            @RequestParam("emergenceName") String emergenceName,
            @RequestParam("secondNumber") Integer secondNumber,
            @RequestParam("address") String address,
            @RequestParam("placeOfBirth") String placeOfBirth,
            @RequestParam("doe") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate doe,
            @RequestParam("jobTitle") String jobTitle,

            // send IDs instead of object
            @RequestParam("zoneId") Integer zoneId,
            @RequestParam("placeId") Integer placeId,
            @RequestParam("managerId") Long managerId,

            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam(value = "applicationLetter", required = false) MultipartFile applicationLetter,
            @RequestParam(value = "chairmanLetter", required = false) MultipartFile chairmanLetter
    ) throws IOException {
        Employee updated = employeeService.updateEmployee(
                id, firstName, middleName, lastName, gender, maritalStatus, dateOfBirth,
                regionName, districtName, wardName, nidaNumber, email, phoneNumber, emergenceName,
                secondNumber, address, doe, jobTitle,
                zoneId, placeId, managerId,
                photo, applicationLetter, chairmanLetter
        );
        return ResponseEntity.ok(updated);
    }

}
