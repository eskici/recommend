package com.moss.project.eneasy.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class BaseDto implements Serializable {
    private Long id;
    private Date creationDate;
    private Date lastChangeDate;
}
