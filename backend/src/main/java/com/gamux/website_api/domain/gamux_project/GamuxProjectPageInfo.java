package com.gamux.website_api.domain.gamux_project;

import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GamuxProjectPageInfo {
    @Id
    private UUID id;
    private String description;
    private String banner;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> externalLinks;

    private String bgColor;
    private String bg2Color;
    private String textColor;
    private String linkColor;
    private String headingColor;
}