package one.digitalinovation.parking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinovation.parking.controller.dto.ParkingDTO;
import one.digitalinovation.parking.controller.mapper.ParkingMapper;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.service.ParkingService;

@RestController
@RequestMapping("/parking")
@Api(tags= "Parking Controller")
public class ParkingController {

	private final ParkingService parkingService;
	private final ParkingMapper parkingMapper;

	public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
		this.parkingService= parkingService;
		this.parkingMapper = parkingMapper;
	}

	@GetMapping
	@ApiOperation("Find all parkings")
	public ResponseEntity<List<ParkingDTO>> findAll(){
		List<Parking> parkingList =  parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	@ApiOperation("Find parking by id")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
		Parking parking =  parkingService.findById(id);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	@ApiOperation("Create new parking")
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
		Parking parkingCreate = parkingMapper.toParking(dto);
		ParkingDTO result = parkingMapper.toParkingDTO(parkingService.create(parkingCreate));
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{id}")
	@ApiOperation("Update parking information")
	public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto){
		Parking parkingUpdate = parkingMapper.toParking(dto);
		ParkingDTO result = parkingMapper.toParkingDTO(parkingService.update(id, parkingUpdate));
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Delete parking")
	public ResponseEntity delete(@PathVariable String id){
		parkingService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}")
	@ApiOperation("Parking checkout")
	public ResponseEntity<ParkingDTO> checkOut(@PathVariable String id) {
		Parking parking = parkingService.checkOut(id);
		return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
	}

}
