package com.maranata.xenia.repository;

import com.maranata.xenia.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
}