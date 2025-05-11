package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.dto.AwardWinnerInputDTO;
import org.wso2.cs.pulse.dto.AwardWinnerResponseDTO;
import org.wso2.cs.pulse.entity.AwardWinner;
import org.wso2.cs.pulse.service.AwardWinnerService;

import java.util.List;

@RestController
@RequestMapping("/pulse/award-winners")
public class AwardWinnerController {

    @Autowired
    private AwardWinnerService awardWinnerService;

    @PostMapping
    public ResponseEntity<AwardWinnerResponseDTO> createAwardWinner(@RequestBody AwardWinnerInputDTO inputDTO) {
        AwardWinner saved = awardWinnerService.saveAwardWinner(inputDTO);
        AwardWinnerResponseDTO response = new AwardWinnerResponseDTO(saved);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AwardWinner> getAllAwardWinners() {
        return awardWinnerService.getAllAwardWinners();
    }
}