package com.maranata.xenia.controller;

import com.maranata.xenia.model.Volunteer;
import com.maranata.xenia.model.VolunteerRequestDTO;
import com.maranata.xenia.model.VolunteerResponseDTO;
import com.maranata.xenia.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService service;

    @PostMapping
    public ResponseEntity<VolunteerResponseDTO> create(@RequestBody VolunteerRequestDTO body) {
        VolunteerResponseDTO newVolunteer = this.service.createVolunteer(body);

        return ResponseEntity.ok(newVolunteer);
    }

    @GetMapping("/{volunteerName}")
    public ResponseEntity<VolunteerResponseDTO> getVolunteer(@PathVariable String volunteerName) {
        VolunteerResponseDTO volunteer = this.service.getVolunteerByName(volunteerName);

        return ResponseEntity.ok(volunteer);
    }

    @GetMapping
    public ResponseEntity<List<VolunteerResponseDTO>> getVolunteers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<VolunteerResponseDTO> volunteersList = this.service.getVolunteers(page, size);

        return ResponseEntity.ok(volunteersList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VolunteerResponseDTO> deleteVolunteer(@PathVariable UUID id) {
        this.service.deleteVolunteerById(id);

        return ResponseEntity.noContent().build();
    }

}
