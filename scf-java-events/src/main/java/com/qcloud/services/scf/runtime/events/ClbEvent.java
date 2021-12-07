package com.qcloud.services.scf.runtime.events;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;
import java.util.Map;

/**
 * Class that represents an Clb Event
 */
public class ClbEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -1030954810507877056L;

    private Map<String, String> headers;

    private Map<String, String> payload;

    /**
     * default constructor
     */
    public ClbEvent() {
    }


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ClbEvent {" +
                "headers=" + headers +
                ", body='" + payload +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClbEvent that = (ClbEvent) o;
        return Objects.equals(getPayload(), that.getPayload()) && Objects.equals(getHeaders(), that.getHeaders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeaders(), getPayload());
    }

    @Override
    public ClbEvent clone() {
        try {
            return (ClbEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
        }
    }
}
