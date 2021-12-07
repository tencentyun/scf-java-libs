package com.qcloud.services.scf.runtime.events;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;


/**
 * Class that represents an Cls Event
 */
public class ClsEvent {
    private static final long serialVersionUID = -6966030226883961108L;

    @JsonProperty(value = "clslogs")
    private ClsData clsLogs;

    public ClsData getClsLogs() {
        return clsLogs;
    }

    public void setClsLogs(ClsData clsLogs) {
        this.clsLogs = clsLogs;
    }

    /**
     * default constructor
     */
    public ClsEvent() {
    }


    /**
     * class that represents proxy request context
     */
    public static class ClsData implements Serializable, Cloneable {

        private static final long serialVersionUID = -8498640336401463322L;

        @JsonProperty(value = "data")
        private String data;

        /**
         * default constructor
         */
        public ClsData() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClsData that = (ClsData) o;
            return Objects.equals(getData(), that.getData());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getData());
        }

        @Override
        public ClsData clone() {
            try {
                return (ClsData) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }

    }

    @Override
    public String toString() {
        return "clslogs {" +
                "data=" + getClsLogs() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClsEvent that = (ClsEvent) o;
        return Objects.equals(getClsLogs(), that.getClsLogs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClsLogs());
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
