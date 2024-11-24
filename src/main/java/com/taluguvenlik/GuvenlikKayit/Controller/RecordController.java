package com.taluguvenlik.GuvenlikKayit.Controller;

import com.taluguvenlik.GuvenlikKayit.Model.RecordModel;
import com.taluguvenlik.GuvenlikKayit.Service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    // Create
    @PostMapping
    public ResponseEntity<RecordModel> createRecord(@RequestBody RecordModel recordModel) {
        Instant now = Instant.now();
        RecordModel createdRecord = recordService.createRecord(recordModel);
        createdRecord.setTarih(String.valueOf(now));
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public List<RecordModel> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordModel> getRecordById(@PathVariable Long id) {
        Optional<RecordModel> record = recordService.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<RecordModel> updateRecord(@PathVariable Long id, @RequestBody RecordModel updatedRecord) {
        RecordModel record = recordService.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        return recordService.deleteRecord(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}