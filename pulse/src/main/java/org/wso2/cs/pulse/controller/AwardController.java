package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.Award;
import org.wso2.cs.pulse.service.AwardService;

import java.util.List;

@RestController
@RequestMapping("/pulse/awards")
public class AwardController {

    @Autowired
    private AwardService awardService;

    @PostMapping
    public Award createAward(@RequestBody Award award) {
        return awardService.saveAward(award);
    }

    @GetMapping
    public List<Award> getAllAwards() {
        return awardService.getAllAwards();
    }
}