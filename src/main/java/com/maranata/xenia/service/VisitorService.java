package com.maranata.xenia.service;

import com.maranata.xenia.model.Visitor;
import com.maranata.xenia.model.Volunteer;
import com.maranata.xenia.model.dto.VisitorRequestDTO;
import com.maranata.xenia.model.dto.VisitorResponseDTO;
import com.maranata.xenia.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository repository;

    @Autowired
    private VolunteerService volunteerService;

    public VisitorResponseDTO createVisitor(VisitorRequestDTO visitor) {

        Volunteer volunteer = volunteerService.getVolunteerEntityById(visitor.responsibleVolunteer());
        Visitor newVisitor = new Visitor();

        newVisitor.setName(visitor.name());
        newVisitor.setPhone(visitor.phone());
        newVisitor.setAge(visitor.age());
        newVisitor.setFirstFeedback(visitor.firstFeedback());
        newVisitor.setResponsibleVolunteer(volunteer);
        newVisitor.setFirstVisitDate(visitor.firstVisitDate());
        newVisitor.setVisitorStatus(visitor.visitorStatus());

        this.repository.save(newVisitor);

        return new VisitorResponseDTO(
                newVisitor.getName(),
                newVisitor.getPhone(),
                newVisitor.getAge(),
                newVisitor.getResponsibleVolunteer().getId()
        );

    }

    public VisitorResponseDTO getVisitorById(UUID id) {
        Visitor visitor = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found"));

        return new VisitorResponseDTO(
                visitor.getName(),
                visitor.getPhone(),
                visitor.getAge(),
                visitor.getResponsibleVolunteer().getId()
        );
    }

    public Page<VisitorResponseDTO> getVisitors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Visitor> visitorsList = this.repository.findAll(pageable);

        return visitorsList.map(visitor -> new VisitorResponseDTO(
                visitor.getName(),
                visitor.getPhone(),
                visitor.getAge(),
                visitor.getResponsibleVolunteer().getId()
        ));
    }

    public void deleteVisitorById(UUID id) {
        Visitor visitor = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found."));

        repository.delete(visitor);

    }

}
