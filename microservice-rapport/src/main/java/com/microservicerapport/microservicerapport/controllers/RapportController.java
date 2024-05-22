package com.microservicerapport.microservicerapport.controllers;

import com.microservicerapport.microservicerapport.models.Report;
import com.microservicerapport.microservicerapport.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class RapportController {
    @Autowired
    private ReportService reportService;

    /**
     * Retrieves a report by patient ID.
     *
     * @param id the ID of the patient
     * @return a ResponseEntity containing the report as a JSON string if found, or
     *         a bad request response if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getReportByPatientId(@PathVariable(value = "id") String id) {
        try {
            Report report = reportService.getReportOfPatient(id);
            if (report != null) {
                return ResponseEntity.ok().body(Report.toDict(report));
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error while generating report");
        }
    }
}
