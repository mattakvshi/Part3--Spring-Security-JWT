package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.community;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import ru.mattakvshi.near.dto.notice.NoticeTemplDTOForOwner;
import ru.mattakvshi.near.entity.EmergencyTypes;
import ru.mattakvshi.near.entity.base.Community;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class CommunityDTOForCommunity {

    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;

    private String communityName;

    private String description;

    private String country;

    private String city;

    private String district;

    private LocalDate registrationDate;

    private List<UserDTOForCommunity> subscribers;

    private List<EmergencyTypes> monitoredEmergencyTypesCount;

    private List<NoticeTemplDTOForOwner> notificationTemplates;

    public static CommunityDTOForCommunity from(Community community) {
        CommunityDTOForCommunity dto = new CommunityDTOForCommunity();
        dto.setId(community.getId());
        dto.setCommunityName(community.getCommunityName());
        dto.setDescription(community.getDescription());
        dto.setCountry(community.getCountry());
        dto.setCity(community.getCity());
        dto.setDistrict(community.getDistrict());
        dto.setRegistrationDate(community.getRegistrationDate());

        dto.setSubscribers(
                community.getSubscribers()
                        .stream()
                        .map(UserDTOForCommunity::from)
                        .collect(Collectors.toList())
        );

        dto.setMonitoredEmergencyTypesCount(community.getMonitoredEmergencyTypes());

        dto.setNotificationTemplates(
                community.getNotificationTemplates()
                .stream()
                .map(NoticeTemplDTOForOwner::from)
                .collect(Collectors.toList())
        );

        return dto;
    }
}
