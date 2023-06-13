package com.project.basebeauty.dataAccess.abstracts;

import com.project.basebeauty.entities.concretes.Expert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertRepository {
    List<Expert> getAll();
}
