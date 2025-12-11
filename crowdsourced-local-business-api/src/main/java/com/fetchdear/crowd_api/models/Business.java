package com.fetchdear.crowd_api.models;

import com.fetchdear.crowd_api.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Business extends BaseEntity {


    private String name;
    private String address;
    private String description;
    private String media;
    private String category;
    private int customerId;
    private int reviewId;
    private int favouriteId;
    private String createdBy;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> workingHours = new HashMap<>();
}
