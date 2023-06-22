package sg.nus.iss.java.team7.models;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

import lombok.Data;

@Data
@MappedSuperclass
public class Account {
    @Column(columnDefinition = "VARCHAR(50) UNIQUE NOT NULL")
    private String email;

    @Column(columnDefinition = "VARCHAR(72) NOT NULL")
    private String password;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime createdAt;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime updatedAt;

}