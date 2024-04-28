package com.microservicerapport.microservicerapport.controllers;

import com.microservicerapport.microservicerapport.models.Report;
import com.microservicerapport.microservicerapport.services.NoteService;
import com.microservicerapport.microservicerapport.services.PatientService;
import com.microservicerapport.microservicerapport.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class RapportController {
    @Autowired
    private ReportService reportService;
//    #TODO call microservice-patient to get age and gender then call microservice-note and get the number of notes, then parse notes and check of words like "pain" and "fever" and return the result
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
