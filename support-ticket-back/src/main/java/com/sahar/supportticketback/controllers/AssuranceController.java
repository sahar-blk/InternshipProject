package com.sahar.supportticketback.controllers;

import com.sahar.supportticketback.entities.*;
import com.sahar.supportticketback.services.PdfProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/assurances")
public class AssuranceController {

    @Autowired
    private PdfProcessingService pdfProcessingService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadAssurance(
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type) {

        try {
            switch (type.toLowerCase()) {
                case "vie":
                    AssuranceVie assuranceVie = pdfProcessingService.processAssuranceViePdf(file);
                    // Sauvegardez l'objet AssuranceVie dans la base de données ici
                    return new ResponseEntity<>(assuranceVie, HttpStatus.OK);

                case "sante":
                    AssuranceSante assuranceSante = pdfProcessingService.processAssuranceSantePdf(file);
                    // Sauvegardez l'objet AssuranceSante dans la base de données ici
                    return new ResponseEntity<>(assuranceSante, HttpStatus.OK);

                case "professionnelle":
                    AssuranceProfessionnelle assuranceProfessionnelle = pdfProcessingService.processAssuranceProfessionnellePdf(file);
                    // Sauvegardez l'objet AssuranceProfessionnelle dans la base de données ici
                    return new ResponseEntity<>(assuranceProfessionnelle, HttpStatus.OK);

                case "automobile":
                    AssuranceAutomobile assuranceAutomobile = pdfProcessingService.processAssuranceAutomobilePdf(file);
                    // Sauvegardez l'objet AssuranceAutomobile dans la base de données ici
                    return new ResponseEntity<>(assuranceAutomobile, HttpStatus.OK);

                case "habitation":
                    AssuranceHabitation assuranceHabitation = pdfProcessingService.processAssuranceHabitationPdf(file);
                    // Sauvegardez l'objet AssuranceHabitation dans la base de données ici
                    return new ResponseEntity<>(assuranceHabitation, HttpStatus.OK);

                default:
                    return new ResponseEntity<>("Type d'assurance non reconnu", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors du traitement du fichier PDF: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
