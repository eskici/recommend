package com.moss.project.eneasy.dto;

import com.moss.project.eneasy.enums.EnumStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDto extends BaseDto {
    private String content;

    private EnumStatus status;

    private String createdBy;

    private String topicName;
}
