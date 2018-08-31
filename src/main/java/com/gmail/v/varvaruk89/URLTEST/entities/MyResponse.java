package com.gmail.v.varvaruk89.urltest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long responseTime;
    private int responseCode;
    private Long responseLength;
    private boolean containsWord;
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "myhost_id", nullable = false)
    private MyHost myHost;


}
