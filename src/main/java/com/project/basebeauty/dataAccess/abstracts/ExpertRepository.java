package com.project.basebeauty.dataAccess.abstracts;

import com.project.basebeauty.entities.concretes.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
    //jpaRepository provides methods such as findAll, findAllById, saveAll, deleteAll
}
