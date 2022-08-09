package one.digitalinovation.parking.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinovation.parking.exception.ParkingNotFoundException;
import one.digitalinovation.parking.model.Parking;

@Service
public class ParkingService {

	private static HashMap<String, Parking> parkingMapping = new HashMap();
	
	
	public List<Parking> findAll(){
		return parkingMapping.values().stream().collect(Collectors.toList());
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Parking findById(String id) throws ParkingNotFoundException {
		Parking parking =  parkingMapping.get(id);
		if(parking == null)throw new ParkingNotFoundException(id);
		return parking;
	}

	public Parking create(Parking parkingCreate) {
		String uUID = getUUID();
		parkingCreate.setId(uUID);
		parkingCreate.setEntryTime(LocalDate.now());
		parkingMapping.put(uUID, parkingCreate);
		return parkingCreate;
	}

	public void delete(String id) {
		 findById(id);
		parkingMapping.remove(id);
	}

	public Parking update(String id, Parking parkingUpdate) {
		 findById(id);
		 parkingMapping.replace(id, parkingUpdate);
		 return parkingUpdate;
	}
}
