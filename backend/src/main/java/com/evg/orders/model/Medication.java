package com.evg.orders.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Medication {
    @Id
    @GenericGenerator(
            name = "medication-sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "medication_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "medication-sequence-generator")
    @Column(nullable = false)
    private Long id;
    @Pattern(regexp = "^[A-Za-z0-9-_]*$", message = "allowed only letters, numbers, ‘-‘, ‘_’")
    private String name;
    private Integer weight;
    @Pattern(regexp = "^[A-Z0-9_]*$", message = "allowed only upper case letters, underscore and numbers")
    private String code;
    @Lob
    private byte[] image;
}
