package com.needibay.email.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Table(name = "nb_system_configuration")
@Entity
public class Configuration implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "microservice")
    private String microservice;

    @Column(name = "config_key")
    private String configKey;

    @Column(name = "config_value")
    private String configValue;

    public Configuration(){}
}
