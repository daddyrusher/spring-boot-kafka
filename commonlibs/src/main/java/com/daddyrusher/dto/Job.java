
package com.daddyrusher.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Job implements Serializable {
    public Job() {
    }

    private String title;
    private String company;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
