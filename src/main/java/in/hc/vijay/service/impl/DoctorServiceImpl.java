package in.hc.vijay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hc.vijay.entity.Doctor;
import in.hc.vijay.exception.DoctorNotFoundException;
import in.hc.vijay.repo.DoctorRepository;
import in.hc.vijay.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;
	
	@Override
	public Long saveDoctor(Doctor doc) {
		return repo.save(doc).getId();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

	@Override
	public void removeDoctor(Long id) {
		repo.delete(getOneDoctor(id));
	}

	@Override
	public Doctor getOneDoctor(Long id) {
		return repo.findById(id).orElseThrow(
				()->new DoctorNotFoundException(id+", not exist")
				);
	}

	@Override
	public void updateDoctor(Doctor doc) {
		if(repo.existsById(doc.getId()))
			repo.save(doc);
		else 
			throw new DoctorNotFoundException(doc.getId()+", not exist"); 
	}

}
