package com.example.simplemicroservice.controller;

import com.example.simplemicroservice.SliceData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/split")
public class AdvancedController {

  @GetMapping("/1/{id}")
  public ResponseEntity<SliceData> part1(@PathVariable String id) {
    var data = new SliceData();
    data.setId(id);
    data.setName("John Clark");
    return ResponseEntity.ok(data);
  }

  @GetMapping("/2/{id}")
  public ResponseEntity<SliceData> part2(@PathVariable String id) {
    var data = new SliceData();
    data.setId(id);
    data.setAddress("1472  Hillview Street, Charlotte, South Carolina");
    return ResponseEntity.ok(data);
  }

  @GetMapping("/3/{id}")
  public ResponseEntity<SliceData> part3(@PathVariable String id) {
    var data = new SliceData();
    data.setId(id);
    data.setNric("S1234567A");
    return ResponseEntity.ok(data);
  }
}
