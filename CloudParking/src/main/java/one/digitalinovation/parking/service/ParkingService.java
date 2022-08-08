package one.digitalinovation.parking.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinovation.parking.model.Parking;

@Service
public class ParkingService {

	private static HashMap<String, Parking> parkingMapping = new HashMap();
	
	static {
		var id = getUUID();
		var anotherID = getUUID();
		Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA","PRETO");
		Parking anotherParking = new Parking(anotherID, "AWS-9282","PR", "WS GOL", "VERMLEHO");
		parkingMapping.put(id, parking);
		parkingMapping.put(anotherID, anotherParking);
	}
	
	public List<Parking> findAll(){
		return parkingMapping.values().stream().collect(Collectors.toList());
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Parking findById(String id) {
		return parkingMapping.get(id);
	}

	public Parking create(Parking parkingCreate) {
		String uUID = getUUID();
		parkingCreate.setId(uUID);
		parkingCreate.setEntryTime(LocalDate.now());
		parkingMapping.put(uUID, parkingCreate);
		return parkingCreate;
	}
}
