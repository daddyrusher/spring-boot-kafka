
package com.daddyrusher.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Billing implements Serializable {
    public Billing() {
    }

    private Card card;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
