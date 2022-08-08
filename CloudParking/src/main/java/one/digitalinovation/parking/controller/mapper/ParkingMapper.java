package one.digitalinovation.parking.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import one.digitalinovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinovation.parking.controller.dto.ParkingDTO;
import one.digitalinovation.parking.model.Parking;

@Component
public class ParkingMapper {

	private static final ModelMapper MODELMAPPER = new ModelMapper();
	
	public ParkingDTO toParkingDTO(Parking parking) {
		return MODELMAPPER.map(parking, ParkingDTO.class);
	}
	
	public Parking toParking(ParkingDTO dto) {
		return MODELMAPPER.map(dto, Parking.class);
	}
	
	public Parking toParking(ParkingCreateDTO dto) {
		return MODELMAPPER.map(dto, Parking.class);
	}
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
       return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
	}

	
}
