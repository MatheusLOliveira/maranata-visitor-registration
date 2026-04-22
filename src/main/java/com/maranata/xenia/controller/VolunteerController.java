package com.maranata.xenia.controller;

import com.maranata.xenia.model.Volunteer;
import com.maranata.xenia.model.VolunteerRequestDTO;
import com.maranata.xenia.model.VolunteerResponseDTO;
import com.maranata.xenia.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<VolunteerResponseDTO> createVolunteer(@RequestBody VolunteerRequestDTO body) {
        VolunteerResponseDTO newVolunteer = this.service.createVolunteer(body);

        return ResponseEntity.ok(newVolunteer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerResponseDTO> getVolunteerById(@PathVariable UUID id) {
        VolunteerResponseDTO volunteer = this.service.getVolunteerById(id);

        return ResponseEntity.ok(volunteer);
    }

    @GetMapping
    public ResponseEntity<Page<VolunteerResponseDTO>> getVolunteers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<VolunteerResponseDTO> volunteersList = this.service.getVolunteers(page, size);
        return ResponseEntity.ok(volunteersList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VolunteerResponseDTO> deleteVolunteer(@PathVariable UUID id) {
        VolunteerResponseDTO deletedVolunteer = this.service.deleteVolunteerById(id);

        return ResponseEntity.noContent().build();
    }

}
