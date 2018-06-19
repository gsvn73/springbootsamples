package com.myapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Lakshmi on 6/13/2018.
 */
@Data
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    private String id;
    private String name;
    private String description;

}
