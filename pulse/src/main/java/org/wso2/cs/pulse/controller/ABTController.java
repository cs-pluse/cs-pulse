package org.wso2.cs.pulse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.ABT;
import org.wso2.cs.pulse.service.ABTService;

import java.util.List;

@RestController
@RequestMapping("/pulse/abt")
public class ABTController
{
    private static final Logger logger = LoggerFactory.getLogger(ABTController.class);

    @Autowired
    private ABTService abtService;

    @PostMapping
    public ResponseEntity<ABT> createABT(@RequestBody ABT abt) {
        ABT savedABT = abtService.saveABT(abt);
        return ResponseEntity.ok(savedABT);
    }

    @GetMapping
    public ResponseEntity<List<ABT>> getAllABTs() {
        List<ABT> abts = abtService.getABTs();
        return ResponseEntity.ok(abts);
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<ABT> getABTById(@PathVariable Long id) {
        return abtService.getABTById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<ABT>> findByABTName(@PathVariable String name) {
        List<ABT> abts = abtService.findByABTName(name);
        return ResponseEntity.ok(abts);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ABT> updateABT(@PathVariable Long id, @RequestBody ABT newABT) {

        return abtService.getABTById(id)
                .map(abt -> {
                    abt.setAbtName(newABT.getAbtName());
                    abt.setBusinessUnit(newABT.getBusinessUnit());
                    return ResponseEntity.ok(newABT);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteABT(@PathVariable Long id) {
        ResponseEntity<Object> objectResponseEntity = abtService.getABTById(id)
                .map(abt -> {
                    abtService.deleteABT(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

        if (objectResponseEntity.getStatusCode().is2xxSuccessful()) {
            logger.info("ABT with ID {} is deleted successfully", id);
        }
        return ResponseEntity.noContent().build();
    }
}
