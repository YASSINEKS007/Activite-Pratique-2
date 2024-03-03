package ma.enset.hospital.service;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;

import java.util.List;
import java.util.Optional;


public interface IHospital {
    Patient savePatient(Patient obj);
    Consultation saveConsultation(Consultation obj);
    Medecin saveMedecin(Medecin obj);
    RendezVous saveRendezVous(RendezVous obj);

    List<Patient> findAll();
    Optional<Patient> findById(Long id);
    Patient updatePatient(Patient obj);
    void deletePatient(Patient obj);

}
