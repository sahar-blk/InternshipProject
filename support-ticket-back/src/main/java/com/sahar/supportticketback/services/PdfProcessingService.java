package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PdfProcessingService {

    public AssuranceVie processAssuranceViePdf(MultipartFile file) throws IOException {
        AssuranceVie assuranceVie = new AssuranceVie();
        String text = extractTextFromPdf(file);

        assuranceVie.setCertificatNaissance(extractValue(text, "Certificat de Naissance"));
        assuranceVie.setExamenMedical(extractValue(text, "Examen Médical"));
        assuranceVie.setJustificatifRevenus(extractValue(text, "Justificatif de Revenus"));
        assuranceVie.setQuestionnaireSante(extractValue(text, "Questionnaire Santé"));

        return assuranceVie;
    }

    public AssuranceSante processAssuranceSantePdf(MultipartFile file) throws IOException {
        AssuranceSante assuranceSante = new AssuranceSante();
        String text = extractTextFromPdf(file);

        assuranceSante.setCarteIdentite(extractValue(text, "Carte d'Identité"));
        assuranceSante.setCertificatMedical(extractValue(text, "Certificat Médical"));
        assuranceSante.setHistoriqueMedical(extractValue(text, "Historique Médical"));
        assuranceSante.setJustificatifRevenus(extractValue(text, "Justificatif de Revenus"));

        return assuranceSante;
    }

    public AssuranceProfessionnelle processAssuranceProfessionnellePdf(MultipartFile file) throws IOException {
        AssuranceProfessionnelle assuranceProfessionnelle = new AssuranceProfessionnelle();
        String text = extractTextFromPdf(file);

        assuranceProfessionnelle.setExtraitKbis(extractValue(text, "Extrait Kbis"));
        assuranceProfessionnelle.setStatutsEntreprise(extractValue(text, "Statuts Entreprise"));
        assuranceProfessionnelle.setBilanComptable(extractValue(text, "Bilan Comptable"));
        assuranceProfessionnelle.setJustificatifQualificationProfessionnelle(extractValue(text, "Justificatif Qualification Professionnelle"));
        assuranceProfessionnelle.setContratTravail(extractValue(text, "Contrat de Travail"));

        return assuranceProfessionnelle;
    }

    public AssuranceAutomobile processAssuranceAutomobilePdf(MultipartFile file) throws IOException {
        AssuranceAutomobile assuranceAutomobile = new AssuranceAutomobile();
        String text = extractTextFromPdf(file);

        assuranceAutomobile.setPermisDeConduire(extractValue(text, "Permis de Conduire"));
        assuranceAutomobile.setCertificatImmatriculation(extractValue(text, "Certificat d'Immatriculation"));
        assuranceAutomobile.setJustificatifAchatVehicule(extractValue(text, "Justificatif Achat Véhicule"));
        assuranceAutomobile.setReleveInformations(extractValue(text, "Relevé d'Informations"));
        assuranceAutomobile.setPhotographiesVehicule(extractValue(text, "Photographies Véhicule"));
        assuranceAutomobile.setCertificatNonGage(extractValue(text, "Certificat Non Gage"));

        return assuranceAutomobile;
    }

    public AssuranceHabitation processAssuranceHabitationPdf(MultipartFile file) throws IOException {
        AssuranceHabitation assuranceHabitation = new AssuranceHabitation();
        String text = extractTextFromPdf(file);

        assuranceHabitation.setJustificatifDomicile(extractValue(text, "Justificatif de Domicile"));
        assuranceHabitation.setÉtatDesLieux(extractValue(text, "État des Lieux"));
        assuranceHabitation.setActeDePropriété(extractValue(text, "Acte de Propriété"));
        assuranceHabitation.setInventaireDesBiensAssurés(extractValue(text, "Inventaire des Biens Assurés"));
        assuranceHabitation.setContratDeLocation(extractValue(text, "Contrat de Location"));
        assuranceHabitation.setPhotographiesDesBiensDeValeur(extractValue(text, "Photographies des Biens de Valeur"));

        return assuranceHabitation;
    }

    private String extractTextFromPdf(MultipartFile file) throws IOException {
        PDDocument document = PDDocument.load(file.getInputStream());
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();
        return text;
    }

    private String extractValue(String text, String fieldName) {
        int index = text.indexOf(fieldName);
        if (index != -1) {
            int endIndex = text.indexOf("\n", index);
            return text.substring(index + fieldName.length() + 1, endIndex).trim();
        }
        return null;
    }
}
