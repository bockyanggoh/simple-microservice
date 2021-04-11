package com.example.simplemicroservice.controller;

import com.example.simplemicroservice.ReturnData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/simple")
public class SimpleController {

  private final List<ReturnData> temporalIds;

  public SimpleController() {
    this.temporalIds = new ArrayList<>();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReturnData> getId(@PathVariable String id) {
    if (!id.isEmpty() || !id.isBlank()) {
      var record = temporalIds.stream().findFirst().filter(r -> r.getId().equals(id));
      return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    return ResponseEntity.badRequest().build();
  }

  @GetMapping
  public ResponseEntity<List<ReturnData>> getAllIds() {
    return ResponseEntity.ok(temporalIds);
  }

  @PostMapping
  public ResponseEntity<ReturnData> createId(String id) {
    if (!id.isEmpty() || !id.isBlank()) {
      var record = new ReturnData(id, UUID.randomUUID().toString());
      temporalIds.add(record);
      return ResponseEntity.ok(record);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping
  public ResponseEntity createMultipleIds(@RequestBody List<ReturnData> data) {
    data.removeIf(r -> r.getId().isBlank() || r.getId().isEmpty());
    temporalIds.addAll(data);
    return ResponseEntity.ok(data);
  }
}
