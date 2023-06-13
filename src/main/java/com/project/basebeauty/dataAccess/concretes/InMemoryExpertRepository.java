package com.project.basebeauty.dataAccess.concretes;

import com.project.basebeauty.dataAccess.abstracts.ExpertRepository;
import com.project.basebeauty.entities.concretes.Expert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository  //This class is an dataAccess object
public class InMemoryExpertRepository implements ExpertRepository {

    List<Expert> experts;

    public InMemoryExpertRepository() {
        experts = new ArrayList<Expert>();

        //adding some data for in memory database.
        // Will be changed to MySql/PostgreSql database later.
        experts.add(new Expert(1, "Bengisu", "Gelin",
                "7788888888", "bengisu@gmail.com",
                "cruelty-free", true));

        experts.add(new Expert(2, "Kirpik", "Gelin",
                "1122222222", "kirpik@gmail.com",
                "vegan", true));

        experts.add(new Expert(3, "sefa", "dundar",
                "2233333333", "sefa@gmail.com",
                "acne-prone", true));

        experts.add(new Expert(4, "bilgesu", "Gelin",
                "5556665566", "bilgesu@gmail.com",
                "clean-ingredients", true));
    }

    @Override
    public List<Expert> getAll() {
        return experts;
    }
}
