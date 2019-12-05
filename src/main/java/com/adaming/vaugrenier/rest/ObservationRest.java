package com.adaming.vaugrenier.rest;

import com.adaming.vaugrenier.dto.ObservationDto;
import com.adaming.vaugrenier.entity.Observation;
import com.adaming.vaugrenier.service.observation.ObservationServiceImpl;
import com.adaming.vaugrenier.service.storage.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ObservationRest {
    @Autowired
    ObservationServiceImpl observationService;
    @Autowired
    ImageServiceImpl imageService;

    @GetMapping("/observations")
    public List<ObservationDto> displayAllObs() {
        List<ObservationDto> list = observationService.getAllObs();
        return list;
    }
    @GetMapping("/observations/{id}")
    public ObservationDto displaySingleObs(@PathVariable (name = "id") Long idToShow) {
        ObservationDto observationDto = observationService.getSpecificObsDto(idToShow);
        return observationDto;
    }
    @PostMapping(path = "/observations/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ObservationDto addObservationSubmit(@ModelAttribute ObservationDto observationDto) {
        if (observationDto.getFile() != null) {
            imageService.storeAvatar(observationDto.getFile());
            observationDto.setImageUrl(observationDto.getFile().getOriginalFilename());
            observationService.createObservation(observationDto.getGenre(), observationDto.getSpecies(), observationDto.getVulgarName(), observationDto.getImageUrl(), observationDto.getDescription());
        } else {
            observationService.createObservation(observationDto.getGenre(), observationDto.getSpecies(), observationDto.getVulgarName(), observationDto.getDescription());
        }
        ObservationDto observationDtoToAdd = observationService.getSpecificObs(observationDto.getVulgarName());
        return observationDtoToAdd;
    }

    @DeleteMapping(path = "observations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ObservationDto> deleteAnimal(@PathVariable(name = "id") Long idToDelete) {
        observationService.deleteObsById(idToDelete);
        List<ObservationDto> dtoList = observationService.getAllObs();
        return dtoList;
    }

    @PatchMapping("/update/counter/{id}")
    public ObservationDto addCounter(@PathVariable (name = "id") Long idToUpdate){
        Observation observationToUpdate=observationService.getSpecificObs(idToUpdate);
        observationService.addCounterObs(observationToUpdate);
        return observationService.getSpecificObs(idToUpdate).toDto();
    }

    @PostMapping("/uploads")
    public MultipartFile handleFileUpload(@RequestBody MultipartFile file) {

        if (file == null) {
            System.out.println("File not found");
        } else {
            System.out.println("File " + file.getOriginalFilename() + " imported");
            System.out.println("Nothing to display");
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
            System.out.println(file.getSize());
            System.out.println(file.getContentType());
            imageService.storeAvatar(file);
        }
        return file;
    }

    @GetMapping("/uploads/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = imageService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
