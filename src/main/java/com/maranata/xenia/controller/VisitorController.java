package com.maranata.xenia.controller;

import com.maranata.xenia.model.dto.VisitorRequestDTO;
import com.maranata.xenia.model.dto.VisitorResponseDTO;
import com.maranata.xenia.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController {

    @Autowired
    private VisitorService service;

    @PostMapping
    public ResponseEntity<VisitorResponseDTO> createVisitor(@RequestBody VisitorRequestDTO body) {
        VisitorResponseDTO visitor = this.service.createVisitor(body);

        return ResponseEntity.ok(visitor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitorResponseDTO> getVisitorById(@PathVariable UUID id) {
        VisitorResponseDTO visitor = this.service.getVisitorById(id);

        return ResponseEntity.ok(visitor);
    }

    @GetMapping
    public ResponseEntity<Page<VisitorResponseDTO>> getVisitors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<VisitorResponseDTO> visitorList = this.service.getVisitors(page, size);
        return ResponseEntity.ok(visitorList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitorById(@PathVariable UUID id) {
        this.service.deleteVisitorById(id);

        return ResponseEntity.noContent().build();
    }

}
