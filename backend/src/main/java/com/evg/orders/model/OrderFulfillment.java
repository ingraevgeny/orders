package com.evg.orders.model;

import com.evg.orders.dict.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class OrderFulfillment {
    @Id
    @GenericGenerator(
            name = "orderFulfillment-sequence-generator",
            type = org.hibernate.id.enhanced.SequenceStyleGenerator.class,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "orderFulfillment_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "orderFulfillment-sequence-generator")
    @Column(nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    private Long droneId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Medication> medications;
    @Column
    private LocalDateTime timestamp = LocalDateTime.now();
}
