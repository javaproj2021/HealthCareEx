package in.hc.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hc.vijay.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
