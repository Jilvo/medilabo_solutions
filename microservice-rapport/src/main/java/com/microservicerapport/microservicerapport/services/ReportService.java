package com.microservicerapport.microservicerapport.services;

import com.microservicerapport.microservicerapport.models.Note;
import com.microservicerapport.microservicerapport.models.Patient;
import com.microservicerapport.microservicerapport.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private PatientService patientService;
    @Autowired
    private NoteService noteService;

    public Report getReportOfPatient(String id) {
        Patient patient = patientService.getPatient(id);
        if (patient != null) {
            List<Note> note = noteService.getNoteOfPatient(id);
            String levelOfRisk = determineLevelOfRisk(note, patient);
            Report report = new Report(patient.getId(), levelOfRisk);
            return report;
        } else {
            return null;
        }
    }

    public String determineLevelOfRisk(List<Note> notes, Patient patient) {
        int age = patient.getAge();
        int numberOfNotes = notes.size();
        String gender = patient.getGender();
        int numberOfTriggerWords = countTriggerWords(notes);

        if (numberOfTriggerWords == 0) {
            return "None";
        } else if (age > 30 && numberOfNotes >= 2 && numberOfNotes <= 5) {
            return "Borderline";
        } else if (age < 30 && gender == "M" && numberOfTriggerWords < 5) {
            return "In Danger";
        } else if (age < 30 && gender == "F" && numberOfTriggerWords < 7) {
            return "In Danger";
        } else if (age >= 30 && numberOfTriggerWords == 6 || numberOfTriggerWords == 7) {
            return "In Danger";

        } else if (age < 30 && gender == "M" && numberOfTriggerWords >= 5) {
            return "Early onset";
        } else if (age < 30 && gender == "F" && numberOfTriggerWords >= 7) {
            return "Early onset";
        } else if (age >= 30 && numberOfTriggerWords >= 8) {
            return "Early onset";
        }
        return "Early onset";
    }

    public int countTriggerWords(List<Note> notes) {
        List<String> triggerWords = getListOfSymptoms();
        int count = 0;
        for (Note note : notes) {
            for (String word : triggerWords) {
                if (note.getNote().contains(word)) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<String> getListOfSymptoms() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            result = new ArrayList<String>(Files.readAllLines(Path.of("src/main/resources/trigger_words.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
