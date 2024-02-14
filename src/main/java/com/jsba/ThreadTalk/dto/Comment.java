package com.jsba.ThreadTalk.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String message;

    @ManyToOne
    @JoinColumn(name = "posted_by_user_id")
    private User postedByUser;

    @ManyToOne
    @JoinColumn(name = "received_by_user_id")
    private User receivedByUser;

    @CreationTimestamp
    private LocalDateTime commentDateAndTime;


}
