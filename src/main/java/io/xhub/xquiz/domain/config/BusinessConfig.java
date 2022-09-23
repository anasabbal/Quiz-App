package io.xhub.xquiz.domain.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "BUSINESS_CONFIG")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessConfig {

    @Id
    private String id;

    @Column(name = "KEY", unique = true)
    private String key;

    @Column(name = "VALUE")
    private String value;


}