package com.maranata.xenia.service;

import com.maranata.xenia.model.Visitor;
import com.maranata.xenia.model.dto.VisitorRequestDTO;
import com.maranata.xenia.model.dto.VisitorResponseDTO;
import com.maranata.xenia.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository repository;

    // TODO: Finish create method
    private VisitorResponseDTO createVisitor(VisitorRequestDTO visitor) {

        Visitor newVisitor = new Visitor();

        

        newVisitor.setName(visitor.name());
        newVisitor.setPhone(visitor.phone());
        newVisitor.setAge(visitor.age());
        newVisitor.setFirstFeedback(visitor.firstFeedback());
        newVisitor.setResponsibleVolunteer(visitor.responsibleVolunteer());
        newVisitor.setVisitorStatus(visitor.visitorStatus());

    }

}
