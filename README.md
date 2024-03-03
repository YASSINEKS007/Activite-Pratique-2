<h1>Système de Gestion Hospitalière</h1>

<p>Ce dépôt contient un Système de Gestion Hospitalière développé en Java et Spring Boot. Il fournit des fonctionnalités pour gérer les patients, les médecins, les rendez-vous et les consultations au sein d'un hôpital.</p>

<h2>Introduction</h2>

<p>Le Système de Gestion Hospitalière comprend plusieurs entités telles que Patient, Médecin, Rendez-vous et Consultation. Ces entités sont interconnectées pour faciliter la gestion des opérations hospitalières.</p>

<h3>Entités :</h3>

<ol>
    <li><strong>Patient</strong> : Représente un patient visitant l'hôpital. Il inclut des informations telles que le nom, la date de naissance et si le patient est actuellement malade.</li>
    <li><strong>Médecin</strong> : Représente un médecin travaillant à l'hôpital. Il inclut des informations telles que le nom, l'email et la spécialité.</li>
    <li><strong>Rendez-vous</strong> : Représente un rendez-vous planifié entre un patient et un médecin. Il inclut la date du rendez-vous et son statut.</li>
    <li><strong>Consultation</strong> : Représente une session de consultation entre un médecin et un patient. Il inclut la date de la consultation et un rapport de la session.</li>
</ol>

<h2>Extraits de code et Explications</h2>

<h3>Classes d'Entité</h3>

<h4>Consultation.java</h4>

<pre><code>&lt;Entity&gt;
&lt;Data @NoArgsConstructor @AllArgsConstructor&gt;
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateConsultation;
    private String rapport;
    @OneToOne
    private RendezVous rendezVous;
}
</code></pre>

<ul>
    <li>Cette classe représente une entité de consultation.</li>
    <li>Elle inclut des champs tels que <code>id</code>, <code>dateConsultation</code>, <code>rapport</code>, et une référence au <code>RendezVous</code> associé.</li>
    <li>Elle est annotée avec <code>@Entity</code>, la spécifiant en tant qu'entité JPA.</li>
    <li>Utilise des annotations Lombok pour générer les getters, setters, les constructeurs et la méthode <code>toString()</code>.</li>
</ul>

<h4>Medecin.java</h4>

<pre><code>&lt;Entity&gt;
&lt;Data @NoArgsConstructor @AllArgsConstructor&gt;
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private Collection&lt;RendezVous&gt; rendezVous;
}
</code></pre>

<ul>
    <li>Cette classe représente une entité de médecin.</li>
    <li>Elle inclut des champs tels que <code>id</code>, <code>nom</code>, <code>email</code>, <code>specialite</code>, et une collection de <code>RendezVous</code> associés.</li>
    <li>Elle est annotée avec <code>@Entity</code>, la spécifiant en tant qu'entité JPA.</li>
    <li>Utilise des annotations Lombok pour générer les getters, setters, les constructeurs et la méthode <code>toString()</code>.</li>
</ul>

<h4>Patient.java</h4>

<pre><code>&lt;Entity&gt;
&lt;Data @NoArgsConstructor @AllArgsConstructor&gt;
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection&lt;RendezVous&gt; rendezVous;
}
</code></pre>

<ul>
    <li>Cette classe représente une entité de patient.</li>
    <li>Elle inclut des champs tels que <code>id</code>, <code>nom</code>, <code>dateNaissance</code>, <code>malade</code>, et une collection de <code>RendezVous</code> associés.</li>
    <li>Elle est annotée avec <code>@Entity</code>, la spécifiant en tant qu'entité JPA.</li>
    <li>Utilise des annotations Lombok pour générer les getters, setters, les constructeurs et la méthode <code>toString()</code>.</li>
</ul>

<h4>RendezVous.java</h4>

<pre><code>&lt;Entity&gt;
&lt;Data @NoArgsConstructor @AllArgsConstructor&gt;
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatutRDV statutRDV;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
</code></pre>

<ul>
    <li>Cette classe représente une entité de rendez-vous.</li>
    <li>Elle inclut des champs tels que <code>id</code>, <code>date</code>, <code>statutRDV</code>, et des références à <code>Patient</code>, <code>Medecin</code>, et <code>Consultation</code> associés.</li>
    <li>Elle est annotée avec <code>@Entity</code>, la spécifiant en tant qu'entité JPA.</li>
    <li>Utilise des annotations Lombok pour générer les getters, setters, les constructeurs et la méthode <code>toString()</code>.</li>
</ul>

<h3>Interfaces de Repository</h3>

<h4>ConsultationRepository.java</h4>

<pre><code>public interface ConsultationRepository extends JpaRepository&lt;Consultation,Long&gt; {
}
</code></pre>

<ul>
    <li>Cette interface fournit les opérations CRUD pour l'entité <code>Consultation</code>.</li>
</ul>

<h4>MedecinRepository.java</h4>

<pre><code>public interface MedecinRepository extends JpaRepository&lt;Medecin,Long&gt; {
}
</code></pre>

<ul>
    <li>Cette interface fournit les opérations CRUD pour l'entité <code>Medecin</code>.</li>
</ul>

<h4>PatientRepository.java</h4>

<pre><code>public interface PatientRepository extends JpaRepository&lt;Patient,Long&gt; {
}
</code></pre>

<ul>
    <li>Cette interface fournit les opérations CRUD pour l'entité <code>Patient</code>.</li>
</ul>

<h4>RendezVousRepository.java</h4>

<pre><code>public interface RendezVousRepository extends JpaRepository&lt;RendezVous,Long&gt; {
}
</code></pre>

<ul>
    <li>Cette interface fournit les opérations CRUD pour l'entité <code>RendezVous</code>.</li>
</ul>

<h3>Interfaces et Implémentations de Service</h3>

<h4>IHospital.java</h4>

<pre><code>public interface IHospital {
    Patient savePatient(Patient obj);
    Consultation saveConsultation(Consultation obj);
    Medecin saveMedecin(Medecin obj);
    RendezVous saveRendezVous(RendezVous obj);

    List&lt;Patient&gt; findAll();
    Optional&lt;Patient&gt; findById(Long id);
    Patient updatePatient(Patient obj);
    void deletePatient(Patient obj);
}
</code></pre>

<ul>
    <li>Cette interface déclare des méthodes pour gérer les patients, les consultations, les médecins et les rendez-vous.</li>
</ul>

<h4>IHospitalImpl.java</h4>

<pre><code>@Service
@Transactional
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

</code></pre>

<ul>
    <li>Cette classe implémente l'interface <code>IHospital</code> en fournissant l'implémentation pour gérer les opérations hospitalières.</li>
    <li>Utilise l'annotation Spring <code>@Service</code> pour la déclarer en tant que classe de service.</li>
    <li>Utilise l'annotation Spring <code>@Transactional</code> pour activer la gestion des transactions.</li>
    <li>Injecte automatiquement les repositories pour accéder aux données.</li>
</ul>

<h2>Conclusion</h2>

<p>Le Système de Gestion Hospitalière fournit une solution robuste pour gérer les patients, les médecins, les rendez-vous et les consultations au sein d'un environnement hospitalier. Avec sa conception d'entités structurée et ses implémentations de repository et de service, il offre une évolutivité et une maintenabilité pour les administrateurs et le personnel hospitalier.</p>