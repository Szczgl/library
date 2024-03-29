package com.crud.library.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STATUS_BOOKS")
public class StatusBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",columnDefinition = "ENUM('AVAILABLE', 'LOST', 'DESTROYED')")
    private Status status;
}
