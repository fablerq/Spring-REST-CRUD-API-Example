package com.example.demo.service;

import com.example.demo.domain.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingServiceInterface {
    List<Greeting> getAllGreetings();
    Optional<Greeting> findGreetingById(Long id);
    Greeting saveGreeting(Greeting greeting);
    void deleteGreetingById(Long id);
}

