package com.crud.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BORROWS")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "STATUS_BOOK_ID")
    private StatusBook statusBook;

    @Column(name = "BORROWED")
    private Date borrowed;

    @Column(name = "RETURNED")
    private Date returned;

}
