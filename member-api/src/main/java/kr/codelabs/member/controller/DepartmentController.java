package kr.codelabs.member.controller;

import kr.codelabs.member.entity.Department;
import kr.codelabs.member.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<?> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable Long id) {
        Department department = departmentService.getDepartment(id);

        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments/name")
    public ResponseEntity<?> getDepartmentByName(@RequestParam String name) {
        Department department = departmentService.getDepartmentByName(name);

        return ResponseEntity.ok(department);
    }

    @PostMapping("/departments")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.createDepartment(department)
                , HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id,
                                              @RequestBody Department department) {
        return new ResponseEntity<>(
                departmentService.updateDepartment(id, department),
                HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
