package com.example.demo.service;

import com.example.demo.domain.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GreetingServiceImpl implements GreetingServiceInterface {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreetingById(Long id) {
        greetingRepository.deleteById(id);
    }

}