package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Expert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ExpertService {


    List<Expert> getAll();
}
