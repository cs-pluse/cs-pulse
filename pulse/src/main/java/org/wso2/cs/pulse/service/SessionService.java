package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    Session saveSession(Session session);
    List<Session> getAllSessions();
    Optional<Session> getSessionById(Integer id);
}
