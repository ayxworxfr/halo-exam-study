package com.evildoer.exam.common.domain;

import java.util.HashMap;

public class HaloResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public HaloResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public HaloResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public HaloResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
