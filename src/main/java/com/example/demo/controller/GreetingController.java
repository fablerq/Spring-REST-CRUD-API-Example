package com.example.demo.controller;

import com.example.demo.domain.Greeting;
import com.example.demo.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

  @Autowired
  private GreetingServiceImpl greetingService;

  @GetMapping()
  public ResponseEntity<List<Greeting>> getAllGreetings(){
    return ResponseEntity.ok(greetingService.getAllGreetings());
  }

  @PostMapping()
  public ResponseEntity<Greeting> createGreeting(@Valid @RequestBody Greeting greeting){
    return ResponseEntity.ok(greetingService.saveGreeting(greeting));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Greeting> findGreeting(@PathVariable Long id) {
    Optional<Greeting> greeting = greetingService.findGreetingById(id);
    if (!greeting.isPresent()) {
      ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(greeting.get());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Greeting> updateGreeting(@PathVariable(value = "id") Long id,
                                                 @Valid @RequestBody Greeting greetingDetails) {
    if (!greetingService.findGreetingById(id).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(greetingService.saveGreeting(greetingDetails));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Greeting> deleteGreeting(@PathVariable(value = "id") Long id) {
    if (!greetingService.findGreetingById(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    greetingService.deleteGreetingById(id);
    return ResponseEntity.ok().build();
  }

}