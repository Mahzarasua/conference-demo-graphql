package com.pluralsight.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.entity.Sessions;
import com.pluralsight.exception.SessionNotFoundException;
import com.pluralsight.repository.SessionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private SessionRepository  sessionRepository;

    public Mutation(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Sessions newSession(String session_name, String session_description, Integer session_length){
        Sessions sessions = new Sessions(session_name,session_description,session_length);
        sessionRepository.save(sessions);
        return sessions;
    }

    public boolean deleteSession(Long session_id){
        sessionRepository.deleteById(session_id);
        return true;
    }

    public Sessions updateSession(String session_name, String session_description, Integer session_length, Long session_id){
        Optional<Sessions> optionalSession = sessionRepository.findById(session_id);

        if(optionalSession.isPresent()){
            Sessions sessions = optionalSession.get();
            sessions.setSession_name(session_name);
            sessions.setSession_description(session_description);
            sessions.setSession_length(session_length);
            sessionRepository.save(sessions);
            return sessions;
        } else {
            throw new SessionNotFoundException("Session Not Found", session_id);
        }
    }
}
