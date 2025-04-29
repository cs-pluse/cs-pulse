package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.Award;
import org.wso2.cs.pulse.service.AwardService;

import java.util.List;

@RestController
@RequestMapping("/pulse/awards")
public class AwardController {

    private final AwardService awardService;

    @Autowired
    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @PostMapping
    public Award createAward(@RequestBody Award award) {
        return awardService.saveAward(award);
    }

    @GetMapping
    public List<Award> getAllAwards() {
        return awardService.getAllAwards();
    }

    @GetMapping("/{id}")
    public Award getAwardById(@PathVariable Integer id) {
        return awardService.getAwardById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAward(@PathVariable Integer id) {
        awardService.deleteAward(id);
    }
}
