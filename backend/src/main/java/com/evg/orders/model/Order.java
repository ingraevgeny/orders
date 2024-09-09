package com.evg.orders.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Order {
    @Id
    @GenericGenerator(
            name = "orders-sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "orders_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "orders-sequence-generator")
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long clientId;
    @Column
    private LocalDateTime timestamp = LocalDateTime.now();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderFulfillment> orderFulfillment;

}
