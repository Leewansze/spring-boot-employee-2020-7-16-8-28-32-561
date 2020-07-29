package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @GetMapping("/companies/{id}")
    private Company getCompany(@PathVariable("id") int id) {
        return companyService.getCompany(id);
    }

    @GetMapping("/companies/{id}/employees")
    private List<Employee> getAllEmployeesOfCompany(@PathVariable("id") int id) {
        return companyService.getAllEmployeesOfCompany(id);
    }

    @GetMapping("/companies")
    private Page<Company> queryCompanies(@PageableDefault(size = 2) Pageable pageable) {
        return companyService.pagingQueryCompanies(pageable);
    }

    @PostMapping("/companies")
    private void addCompany(@RequestBody() Company company) {
        companyService.addCompany(company);
    }

    @DeleteMapping("/companies/{id}")
    private void deleteAllEmployeesOfCompany(@PathVariable("id") int id) {
        companyService.deleteAllEmployeesOfCompany(id);
    }

    @PutMapping("/companies/{id}")
    public void updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
    }
}
