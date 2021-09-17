package com.pocjasper.pocjasper.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
@AllArgsConstructor
@Builder
public class User {

    @Id
    private UUID id;
    private String name;
    private String email;
    private String birth;

}