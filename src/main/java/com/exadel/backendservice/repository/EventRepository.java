package com.exadel.backendservice.repository;

import com.exadel.backendservice.entity.Event;
import com.exadel.backendservice.model.EventStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends PagingAndSortingRepository<Event, Integer> {

    Optional<Event> findByName(String name);

    Boolean existsByName(String name);

    List<Event> findByEventStatus(EventStatus eventStatus,  Pageable pageable);
}
