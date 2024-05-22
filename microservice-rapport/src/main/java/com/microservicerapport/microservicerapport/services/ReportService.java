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
import java.util.Objects;

@Service
public class ReportService {
    @Autowired
    private PatientService patientService;
    @Autowired
    private NoteService noteService;

    /**
     * Retrieves the report of a patient based on their ID.
     *
     * @param id The ID of the patient.
     * @return The report of the patient.
     */
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

    /**
     * Determines the level of risk based on the given list of notes and patient
     * information.
     *
     * @param notes   the list of notes
     * @param patient the patient information
     * @return the level of risk as a string
     */
    public String determineLevelOfRisk(List<Note> notes, Patient patient) {
        int age = patient.getAge();
        int numberOfNotes = notes.size();
        String gender = patient.getGender();
        int numberOfTriggerWords = countTriggerWords(notes);
        if (numberOfTriggerWords == 0) {
            return "None";
        } else if (age > 30 && numberOfTriggerWords >= 2 && numberOfTriggerWords <= 5) {
            return "Borderline";
        } else if (age < 30 && Objects.equals(gender, "M") && numberOfTriggerWords < 5) {
            return "In Danger";
        } else if (age < 30 && Objects.equals(gender, "F") && numberOfTriggerWords < 7) {
            return "In Danger";
        } else if (age >= 30 && numberOfTriggerWords == 6 || numberOfTriggerWords == 7) {
            return "In Danger";

        } else if (age < 30 && Objects.equals(gender, "M") && numberOfTriggerWords >= 5) {
            return "Early onset";
        } else if (age < 30 && Objects.equals(gender, "F") && numberOfTriggerWords >= 7) {
            return "Early onset";
        } else if (age >= 30 && numberOfTriggerWords >= 8) {
            return "Early onset";
        }
        return "None";
    }

    public int countTriggerWords(List<Note> notes) {
        List<String> triggerWords = getListOfSymptoms();
        int count = 0;
        for (Note note : notes) {
            String[] wordsInNote = note.getNote().toLowerCase().split("\\s+");
            for (String wordInNote : wordsInNote) {
                for (String triggerWord : triggerWords) {
                    if (wordInNote.contains(triggerWord.toLowerCase())) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Retrieves a list of symptoms from a text file.
     * 
     * @return a list of symptoms
     */
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
