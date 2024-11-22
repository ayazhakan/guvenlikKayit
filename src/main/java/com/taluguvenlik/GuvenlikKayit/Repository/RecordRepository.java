package com.taluguvenlik.GuvenlikKayit.Repository;
import com.taluguvenlik.GuvenlikKayit.Model.RecordModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<RecordModel, Long> {
    // İhtiyaç duyulursa özelleştirilmiş sorgular burada tanımlanabilir
}
