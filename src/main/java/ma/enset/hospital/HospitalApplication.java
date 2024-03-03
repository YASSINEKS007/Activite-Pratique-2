package ma.enset.hospital;

import ma.enset.hospital.ennumeration.StatutRDV;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.service.IHospitalImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalImpl iHospitalImpl){
		return args -> {
			Patient p =new Patient();
			p.setNom("Yassine");
			p.setDateNaissance(new Date());
			p.setMalade(Math.random() > 0.5? true:false);
			p.setRendezVous(null);
			iHospitalImpl.savePatient(p);

			Patient p2 = new Patient();
			p2.setNom("Fatima");
			p2.setDateNaissance(new Date());
			p2.setMalade(Math.random() > 0.5 ? true : false);
			p2.setRendezVous(null);
			iHospitalImpl.savePatient(p2);



			Medecin m = new Medecin();
			m.setNom("Ali");
			m.setSpecialite(Math.random() < 0.5 ? "Dentiste" : "Ophtalmologiste");
			m.setEmail("Ali@gmail.com");
			m.setRendezVous(null);
			iHospitalImpl.saveMedecin(m);

			Medecin m2 = new Medecin();
			m2.setNom("Karim");
			m2.setSpecialite(Math.random() < 0.5 ? "Cardiologue" : "Gynécologue");
			m2.setEmail("karim@example.com");
			m2.setRendezVous(null);
			iHospitalImpl.saveMedecin(m2);



			RendezVous rv = new RendezVous();
			rv.setDate(new Date());
			rv.setPatient(p);
			rv.setMedecin(m);
			rv.setConsultation(null);
			rv.setStatutRDV(StatutRDV.PENDING);
			iHospitalImpl.saveRendezVous(rv);

			RendezVous rv2 = new RendezVous();
			rv2.setDate(new Date());
			rv2.setPatient(p2);
			rv2.setMedecin(m2);
			rv2.setConsultation(null);
			rv2.setStatutRDV(StatutRDV.DONE);
			iHospitalImpl.saveRendezVous(rv2);


			Consultation cs = new Consultation();
			cs.setDateConsultation(new Date());
			cs.setRendezVous(rv);
			cs.setRapport("Rapport...");
			iHospitalImpl.saveConsultation(cs);

			Consultation cs2 = new Consultation();
			cs2.setDateConsultation(new Date());
			cs2.setRendezVous(rv2);
			cs2.setRapport("Rapport de la consultation...");
			iHospitalImpl.saveConsultation(cs2);

		};
	}

}
