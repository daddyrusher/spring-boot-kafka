package com.daddyrusher.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Serializable {
    public UserData() {
    }

    private List<Data> data = new ArrayList<>();

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}