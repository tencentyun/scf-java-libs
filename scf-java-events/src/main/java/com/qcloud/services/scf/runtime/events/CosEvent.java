package example.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents cos events
 */
public class CosEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = 5980382355367293090L;

    @JsonProperty(value = "Records")
    private List<Record> records;

    /**
     *  class that represents a cos event record
     */

    public static class Record implements Serializable, Cloneable {

        private static final long serialVersionUID = 21670164197981778L;

        private CosInfo cos;

        private Event event;

        public Record() {}

        public CosInfo getCos() {
            return cos;
        }

        public void setCos(CosInfo cos) {
            this.cos = cos;
        }

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "cos=" + cos +
                    ", event=" + event +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Record record = (Record) o;
            return Objects.equals(getCos(), record.getCos()) &&
                    Objects.equals(getEvent(), record.getEvent());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCos(), getEvent());
        }

        @Override
        public Record clone() {
            try {
                return (Record) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    }

    public static class CosInfo implements Serializable, Cloneable {

        private static final long serialVersionUID = 2009783778201378583L;

        private String cosSchemaVersion;

        private CosObjectInfo cosObject;

        private CosBucketInfo cosBucket;

        private String cosNotificationId;

        /**
         * default constructor
         */
        public CosInfo() {}

        public String getCosSchemaVersion() {
            return cosSchemaVersion;
        }

        public void setCosSchemaVersion(String cosSchemaVersion) {
            this.cosSchemaVersion = cosSchemaVersion;
        }

        public CosObjectInfo getCosObject() {
            return cosObject;
        }

        public void setCosObject(CosObjectInfo cosObject) {
            this.cosObject = cosObject;
        }

        public CosBucketInfo getCosBucket() {
            return cosBucket;
        }

        public void setCosBucket(CosBucketInfo cosBucket) {
            this.cosBucket = cosBucket;
        }

        public String getCosNotificationId() {
            return cosNotificationId;
        }

        public void setCosNotificationId(String cosNotificationId) {
            this.cosNotificationId = cosNotificationId;
        }

        @Override
        public String toString() {
            return "CosInfo{" +
                    "cosSchemaVersion='" + cosSchemaVersion + '\'' +
                    ", cosObject=" + cosObject +
                    ", cosBucket=" + cosBucket +
                    ", cosNotificationId='" + cosNotificationId + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CosInfo cosInfo = (CosInfo) o;
            return Objects.equals(getCosSchemaVersion(), cosInfo.getCosSchemaVersion()) &&
                    Objects.equals(getCosObject(), cosInfo.getCosObject()) &&
                    Objects.equals(getCosBucket(), cosInfo.getCosBucket()) &&
                    Objects.equals(getCosNotificationId(), cosInfo.getCosNotificationId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCosSchemaVersion(), getCosObject(), getCosBucket(), getCosNotificationId());
        }

        @Override
        public Record clone() {
            try {
                return (Record) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }

    }

    public static class CosObjectInfo implements Serializable, Cloneable {

        private static final long serialVersionUID = -970953012472079051L;

        private String url;

        private Map<String, String> meta;

        private String vid;

        private String key;

        private long size;

        public CosObjectInfo() {}

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Map<String, String> getMeta() {
            return meta;
        }

        public void setMeta(Map<String, String> meta) {
            this.meta = meta;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "CosObjectInfo{" +
                    "url='" + url + '\'' +
                    ", meta=" + meta +
                    ", vid='" + vid + '\'' +
                    ", key='" + key + '\'' +
                    ", size=" + size +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CosObjectInfo that = (CosObjectInfo) o;
            return Objects.equals(getUrl(), that.getUrl()) &&
                    Objects.equals(getMeta(), that.getMeta()) &&
                    Objects.equals(getVid(), that.getVid()) &&
                    Objects.equals(getKey(), that.getKey()) &&
                    Objects.equals(getSize(), that.getSize());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getUrl(), getMeta(), getVid(), getKey(), getSize());
        }

        @Override
        public CosObjectInfo clone() {
            try {
                return (CosObjectInfo) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    }

    public static class CosBucketInfo implements Serializable, Cloneable {

        private static final long serialVersionUID = -4404286108379963343L;

        private String region;

        private String name;

        private String appid;

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public CosBucketInfo() {}

        @Override
        public String toString() {
            return "CosBucketInfo{" +
                    "region='" + region + '\'' +
                    ", name='" + name + '\'' +
                    ", appid='" + appid + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CosBucketInfo that = (CosBucketInfo) o;
            return Objects.equals(getRegion(), that.getRegion()) &&
                    Objects.equals(getName(), that.getName()) &&
                    Objects.equals(getAppid(), that.getAppid());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRegion(), getName(), getAppid());
        }

        @Override
        public CosBucketInfo clone() {
            try {
                return (CosBucketInfo) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    }

    public static class Event implements Serializable, Cloneable {

        private static final long serialVersionUID = 1603582252592351570L;

        private String eventName;

        private String eventVersion;

        private Integer eventTime;

        private String eventSource;

        private RequestParameters requestParameters;

        private String eventQueue;

        private String reservedInfo;

        private Integer reqid;

        public Event() {}

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getEventVersion() {
            return eventVersion;
        }

        public void setEventVersion(String eventVersion) {
            this.eventVersion = eventVersion;
        }

        public Integer getEventTime() {
            return eventTime;
        }

        public void setEventTime(Integer eventTime) {
            this.eventTime = eventTime;
        }

        public String getEventSource() {
            return eventSource;
        }

        public void setEventSource(String eventSource) {
            this.eventSource = eventSource;
        }

        public RequestParameters getRequestParameters() {
            return requestParameters;
        }

        public void setRequestParameters(RequestParameters requestParameters) {
            this.requestParameters = requestParameters;
        }

        public String getEventQueue() {
            return eventQueue;
        }

        public void setEventQueue(String eventQueue) {
            this.eventQueue = eventQueue;
        }

        public String getReservedInfo() {
            return reservedInfo;
        }

        public void setReservedInfo(String reservedInfo) {
            this.reservedInfo = reservedInfo;
        }

        public Integer getReqid() {
            return reqid;
        }

        public void setReqid(Integer reqid) {
            this.reqid = reqid;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "eventName='" + eventName + '\'' +
                    ", eventVersion='" + eventVersion + '\'' +
                    ", eventTime=" + eventTime +
                    ", eventSource='" + eventSource + '\'' +
                    ", requestParameters=" + requestParameters +
                    ", eventQueue='" + eventQueue + '\'' +
                    ", reservedInfo='" + reservedInfo + '\'' +
                    ", reqid=" + reqid +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return Objects.equals(getEventName(), event.getEventName()) &&
                    Objects.equals(getEventVersion(), event.getEventVersion()) &&
                    Objects.equals(getEventTime(), event.getEventTime()) &&
                    Objects.equals(getEventSource(), event.getEventSource()) &&
                    Objects.equals(getRequestParameters(), event.getRequestParameters()) &&
                    Objects.equals(getEventQueue(), event.getEventQueue()) &&
                    Objects.equals(getReservedInfo(), event.getReservedInfo()) &&
                    Objects.equals(getReqid(), event.getReqid());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getEventName(), getEventVersion(), getEventTime(), getEventSource(), getRequestParameters(), getEventQueue(), getReservedInfo(), getReqid());
        }

        @Override
        public Event clone() {
            try {
                return (Event) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    }

    public static class RequestParameters implements Serializable, Cloneable {

        private static final long serialVersionUID = 9038454546815594640L;

        private String requestSourceIP;

        private Map<String, String> requestHeaders;

        public RequestParameters() {}

        public String getRequestSourceIP() {
            return requestSourceIP;
        }

        public void setRequestSourceIP(String requestSourceIP) {
            this.requestSourceIP = requestSourceIP;
        }

        public Map<String, String> getRequestHeaders() {
            return requestHeaders;
        }

        public void setRequestHeaders(Map<String, String> requestHeaders) {
            this.requestHeaders = requestHeaders;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RequestParameters that = (RequestParameters) o;
            return Objects.equals(getRequestSourceIP(), that.getRequestSourceIP()) &&
                    Objects.equals(getRequestHeaders(), that.getRequestHeaders());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRequestSourceIP(), getRequestHeaders());
        }

        @Override
        public RequestParameters clone() {
            try {
                return (RequestParameters) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    }

    public CosEvent() {}

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "CosEvent{" +
                "records=" + records +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CosEvent cosEvent = (CosEvent) o;
        return Objects.equals(getRecords(), cosEvent.getRecords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecords());
    }

    @Override
    public CosEvent clone() {
        try {
            return (CosEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
        }
    }
}
