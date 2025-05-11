package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.Session;
import org.wso2.cs.pulse.service.SessionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pulse/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        Session savedSession = sessionService.saveSession(session);
        return ResponseEntity.ok(savedSession);
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Integer id) {
        Optional<Session> session = sessionService.getSessionById(id);
        return session.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
