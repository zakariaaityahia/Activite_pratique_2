package enset.ma.app.Modules.Patient;

import enset.ma.app.Modules.Patient.Entity.Patient;
import enset.ma.app.Modules.Patient.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient/")
public class PatientResource {
    private PatientService patientService;

    @Autowired
    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("save")
    public Patient save(@RequestBody Patient patient) {
        return this.patientService.save(patient);
    }

    @PutMapping("update")
    public Patient update(@RequestBody Patient patient) throws Exception {
        return this.patientService.update(patient);
    }

    @GetMapping("get/{id}")
    public Patient getById(@PathVariable Long id) throws Exception {
        return this.patientService.getById(id);
    }

    @GetMapping("index")
    public List<Patient> index() {
        return this.patientService.index();
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable long id) throws Exception {
        return this.patientService.delete(id);
    }
}
