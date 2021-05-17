package com.moss.project.eneasy.dto;

import com.moss.project.eneasy.enums.EnumStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntryDto extends BaseDto {
    private String content;
    private String createdBy;
    private String topicName;
}
