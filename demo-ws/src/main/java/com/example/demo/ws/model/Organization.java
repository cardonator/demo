package com.example.demo.ws.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement(name = "organization")
public class Organization {

    private String id;

    public Organization(String id) {
        this.id = id;
    }
}