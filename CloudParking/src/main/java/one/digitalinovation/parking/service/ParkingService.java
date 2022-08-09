package one.digitalinovation.parking.service;


import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinovation.parking.exception.ParkingNotFoundException;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.repository.ParkingRepository;

@Service
public class ParkingService {

	private final ParkingRepository parkingRepository;
	
	public ParkingService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}
	
	@Transactional(readOnly  = true)
	public List<Parking> findAll(){
		return parkingRepository.findAll();
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Parking findById(String id) throws ParkingNotFoundException {
		return parkingRepository.findById(id).orElseThrow(()-> new  ParkingNotFoundException(id));
	}

	@Transactional
	public Parking create(Parking parkingCreate) {
		String uUID = getUUID();
		parkingCreate.setId(uUID);
		parkingCreate.setEntryTime(LocalDateTime.now());
		return parkingRepository.save(parkingCreate);
	}

	@Transactional
	public void delete(String id) {
		 findById(id);
		 parkingRepository.deleteById(id);
		 
	}

	@Transactional
	public Parking update(String id, Parking parkingUpdate) {
		Parking parking = findById(id);     
		parking.setColor(parkingUpdate.getColor());
		parking.setLicense(parkingUpdate.getLicense());
		parking.setModel(parkingUpdate.getModel());
		parking.setState(parkingUpdate.getState());
		 return parkingRepository.save(parking);
	}
	
	@Transactional
	public Parking checkOut(String id) {
        Parking parking = findById(id);
        parking.setExitTime(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        parkingRepository.save(parking);
        return parking;
    }
}
