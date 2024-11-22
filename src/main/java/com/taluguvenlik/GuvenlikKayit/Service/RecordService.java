package com.taluguvenlik.GuvenlikKayit.Service;

import com.taluguvenlik.GuvenlikKayit.Model.RecordModel;
import com.taluguvenlik.GuvenlikKayit.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    // Create
    public RecordModel createRecord(RecordModel recordModel) {
        return recordRepository.save(recordModel);
    }

    // Read
    public List<RecordModel> getAllRecords() {
        return recordRepository.findAll();
    }

    public Optional<RecordModel> getRecordById(Long id) {
        return recordRepository.findById(id);
    }

    // Update
    public RecordModel updateRecord(Long id, RecordModel updatedRecord) {
        if (recordRepository.existsById(id)) {
            updatedRecord.setId(id);
            return recordRepository.save(updatedRecord);
        }
        return null;
    }

    // Delete
    public boolean deleteRecord(Long id) {
        if (recordRepository.existsById(id)) {
            recordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

