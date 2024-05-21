package enset.ma.app.Modules.Patient.Service;

import enset.ma.app.Modules.Patient.Entity.Patient;
import enset.ma.app.Modules.Patient.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return this.patientRepository.save(patient);
    }

    public Patient update(Patient patient) throws Exception {
        Patient patientUpdated = this.patientRepository.findOneById(patient.getId());

        if(patientUpdated == null) {
            throw new Exception("Patient n'existe pas");
        }
        return this.patientRepository.save(patientUpdated);
    }

    public Patient getById(Long id) throws Exception {
        Patient patient = this.patientRepository.findOneById(id);

        if(patient == null) {
            throw new Exception("Patient n'existe pas");
        }
        return patient;
    }

    public List<Patient> index() {
        return this.patientRepository.findAll();
    }

    public boolean delete(Long id) throws Exception {
        boolean isDeleted = false;
        Patient patient = this.patientRepository.findOneById(id);

        if(patient == null) {
            throw new Exception("Patient n'existe pas");
        }
        else {
            isDeleted = true;
        }
        return isDeleted;
    }
}
