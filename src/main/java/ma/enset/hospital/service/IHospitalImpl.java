package ma.enset.hospital.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IHospitalImpl implements IHospital{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public IHospitalImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient obj) {
        return patientRepository.save(obj);
    }

    @Override
    public Consultation saveConsultation(Consultation obj) {
        return consultationRepository.save(obj);
    }

    @Override
    public Medecin saveMedecin(Medecin obj) {
        return medecinRepository.save(obj);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous obj) {
        return rendezVousRepository.save(obj);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient updatePatient(Patient obj) {
        return patientRepository.saveAndFlush(obj);
    }

    @Override
    public void deletePatient(Patient obj) {
        patientRepository.delete(obj);
    }
}
