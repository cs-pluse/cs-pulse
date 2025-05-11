package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.Session;
import org.wso2.cs.pulse.repository.SessionRepository;
import org.wso2.cs.pulse.service.SessionService;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Optional<Session> getSessionById(Integer id) {
        return sessionRepository.findById(id);
    }
}
