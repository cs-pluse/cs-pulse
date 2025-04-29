package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.IndividualAward;
import org.wso2.cs.pulse.service.IndividualAwardService;

import java.util.List;

@RestController
@RequestMapping("/api/individual-awards")
public class IndividualAwardController {

    private final IndividualAwardService individualAwardService;

    @Autowired
    public IndividualAwardController(IndividualAwardService individualAwardService) {
        this.individualAwardService = individualAwardService;
    }

    @PostMapping
    public IndividualAward createIndividualAward(@RequestBody IndividualAward individualAward) {
        return individualAwardService.saveIndividualAward(individualAward);
    }

    @GetMapping
    public List<IndividualAward> getAllIndividualAwards() {
        return individualAwardService.getAllIndividualAwards();
    }

    @GetMapping("/{id}")
    public IndividualAward getIndividualAwardById(@PathVariable Long id) {
        return individualAwardService.getIndividualAwardById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIndividualAward(@PathVariable Long id) {
        individualAwardService.deleteIndividualAward(id);
    }
}
