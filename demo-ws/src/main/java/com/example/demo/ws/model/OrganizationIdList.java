package com.example.demo.ws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@XmlRootElement(name = "organizations")
public class OrganizationIdList {
    @XmlElementWrapper(name = "organizations")
    @XmlElement(name = "organization")
    @JsonProperty("organizations")
    private List<Organization> orgIds;

    public OrganizationIdList(List<String> ids) {
        orgIds = new ArrayList<>(ids.size());
        orgIds.addAll(ids.stream().map(Organization::new).collect(Collectors.toList()));
    }
}
