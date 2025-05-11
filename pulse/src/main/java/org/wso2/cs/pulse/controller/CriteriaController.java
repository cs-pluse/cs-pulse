package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.Criteria;
import org.wso2.cs.pulse.service.CriteriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pulse/criteria")
public class CriteriaController {

    @Autowired
    private CriteriaService criteriaService;

    @PostMapping
    public ResponseEntity<Criteria> createCriteria(@RequestBody Criteria criteria) {
        Criteria saved = criteriaService.saveCriteria(criteria);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Criteria>> getAllCriteria() {
        List<Criteria> list = criteriaService.getAllCriteria();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Criteria> getCriteriaById(@PathVariable Integer id) {
        Optional<Criteria> criteria = criteriaService.getCriteriaById(id);
        return criteria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
