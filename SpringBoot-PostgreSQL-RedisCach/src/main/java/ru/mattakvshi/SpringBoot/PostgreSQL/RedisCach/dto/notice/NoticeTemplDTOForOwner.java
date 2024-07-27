package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.notice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.EmergencyTypes;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.NotificationTemplate;


import java.io.Serializable;
import java.util.UUID;

@Data
public class NoticeTemplDTOForOwner implements Serializable  {

    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;

    private String templateName;

    private String message;

    private EmergencyTypes emergencyType;

    public static NoticeTemplDTOForOwner from(NotificationTemplate template) {
        NoticeTemplDTOForOwner dto = new NoticeTemplDTOForOwner();
        dto.setId(template.getId());
        dto.setTemplateName(template.getTemplateName());
        dto.setMessage(template.getMessage());
        dto.setEmergencyType(template.getEmergencyType());
        return dto;
    }
}
