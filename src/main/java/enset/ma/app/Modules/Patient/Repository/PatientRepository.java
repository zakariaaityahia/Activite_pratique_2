package enset.ma.app.Modules.Patient.Repository;

import enset.ma.app.Modules.Patient.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findOneById(Long id);
}
