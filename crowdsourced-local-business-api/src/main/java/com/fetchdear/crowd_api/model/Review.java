package com.fetchdear.crowd_api.model;

import com.fetchdear.crowd_api.model.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Review extends BaseEntity<Long> {

    String title;
    int user_id;
    int business_id;
    String content;
    int ratings;


}
