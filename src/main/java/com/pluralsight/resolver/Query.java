package com.pluralsight.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pluralsight.entity.Sessions;
import com.pluralsight.exception.SessionNotFoundException;
import com.pluralsight.repository.SessionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private SessionRepository sessionRepository;

    public Query(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Iterable<Sessions> findAllSessions(){
        return sessionRepository.findAll();
    }

    public Sessions findSession(Long session_id){
        Optional<Sessions> optionalSession = sessionRepository.findById(session_id);

        if(optionalSession.isPresent()){
            Sessions sessions = optionalSession.get();
            return sessions;
        } else {
            throw new SessionNotFoundException("Session Not Found", session_id);
        }
    }

    public long countSessions(){
        return sessionRepository.count();
    }
}
