package com.appdev.cruquihi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.appdev.cruquihi.entity.EventEntity;
import com.appdev.cruquihi.repository.EventRepository;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

    private final EventRepository eventRepo;

    public EventController(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    // CREATE
    @PostMapping
    public EventEntity createEvent(@RequestBody EventEntity event) {
        return eventRepo.save(event);
    }

    // READ ALL
    @GetMapping
    public List<EventEntity> getAllEvents() {
        return eventRepo.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public EventEntity getEventById(@PathVariable int id) {
        return eventRepo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public EventEntity updateEvent(@PathVariable int id, @RequestBody EventEntity updatedEvent) {
        return eventRepo.findById(id).map(event -> {
            event.setEventName(updatedEvent.getEventName());
            event.setEventDescription(updatedEvent.getEventDescription());
            event.setEventVenue(updatedEvent.getEventVenue());
            event.setEventStartTime(updatedEvent.getEventStartTime());
            event.setEventEndTime(updatedEvent.getEventEndTime());
            event.setEventStatus(updatedEvent.getEventStatus());
            event.setEventCategory(updatedEvent.getEventCategory());
            event.setTicketLimit(updatedEvent.getTicketLimit());
            return eventRepo.save(event);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventRepo.deleteById(id);
        return "Event deleted successfully.";
    }
}

