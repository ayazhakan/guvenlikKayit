package com.taluguvenlik.GuvenlikKayit.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class RecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String aracPlaka;
    String cikisSaati;
    String donusSaati;
    String gidilenYer;
    String aracKullanicisi;
    Date tarih;
}
