package com.fetchdear.crowd_api.model;

import com.fetchdear.crowd_api.model.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Business extends BaseEntity<Long> {

    private String name;
    private String address;
    private String description;
    private String media;
    private String category;
    private int customerId;
    private int reviewId;
    private int favouriteId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> workingHours = new HashMap<>();
}
