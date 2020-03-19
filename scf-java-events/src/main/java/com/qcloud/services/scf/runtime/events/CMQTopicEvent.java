package com.qcloud.services.scf.runtime.events;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents an CMQ Topic Event
 */
public class CMQTopicEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -6966030226883961108L;

    @JsonProperty(value = "Records")
    private List<Record> records;

    public static class Record implements Serializable, Cloneable {

        private static final long serialVersionUID = -6259891246636380278L;

        @JsonProperty(value = "CMQ")
        private MsgInfo msg;

        public Record() {}

        public MsgInfo getMsg() {
            return msg;
        }

        public void setMsg(MsgInfo msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "msg=" + msg +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Record record = (Record) o;
            return Objects.equals(getMsg(), record.getMsg());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMsg());
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

    public static class MsgInfo implements Serializable, Cloneable {

        private static final long serialVersionUID = 5841202368022190972L;

        private String type;

        private Integer topicOwner;

        private String topicName;

        private String subscriptionName;

        private String publishTime;

        private String msgId;

        private String requestId;

        private String msgBody;

        private String msgTag;

        public MsgInfo() {}

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getTopicOwner() {
            return topicOwner;
        }

        public void setTopicOwner(Integer topicOwner) {
            this.topicOwner = topicOwner;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getSubscriptionName() {
            return subscriptionName;
        }

        public void setSubscriptionName(String subscriptionName) {
            this.subscriptionName = subscriptionName;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getMsgBody() {
            return msgBody;
        }

        public void setMsgBody(String msgBody) {
            this.msgBody = msgBody;
        }

        public String getMsgTag() {
            return msgTag;
        }

        public void setMsgTag(String msgTag) {
            this.msgTag = msgTag;
        }

        @Override
        public String toString() {
            return "MsgInfo{" +
                    "type='" + type + '\'' +
                    ", topicOwner=" + topicOwner +
                    ", topicName='" + topicName + '\'' +
                    ", subscriptionName='" + subscriptionName + '\'' +
                    ", publishTime='" + publishTime + '\'' +
                    ", msgId='" + msgId + '\'' +
                    ", requestId='" + requestId + '\'' +
                    ", msgBody='" + msgBody + '\'' +
                    ", msgTag=" + msgTag +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MsgInfo msgInfo = (MsgInfo) o;
            return Objects.equals(getType(), msgInfo.getType()) &&
                    Objects.equals(getTopicOwner(), msgInfo.getTopicOwner()) &&
                    Objects.equals(getTopicName(), msgInfo.getTopicName()) &&
                    Objects.equals(getSubscriptionName(), msgInfo.getSubscriptionName()) &&
                    Objects.equals(getPublishTime(), msgInfo.getPublishTime()) &&
                    Objects.equals(getMsgId(), msgInfo.getMsgId()) &&
                    Objects.equals(getRequestId(), msgInfo.getRequestId()) &&
                    Objects.equals(getMsgBody(), msgInfo.getMsgBody()) &&
                    Objects.equals(getMsgTag(), msgInfo.getMsgTag());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getType(), getTopicOwner(), getTopicName(), getSubscriptionName(), getPublishTime(), getMsgId(), getRequestId(), getMsgBody(), getMsgTag());
        }

        @Override
        public MsgInfo clone() {
            try {
                return (MsgInfo) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    }

    public CMQTopicEvent() {}

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "CMQTopicEvent{" +
                "records=" + records +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CMQTopicEvent that = (CMQTopicEvent) o;
        return Objects.equals(getRecords(), that.getRecords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecords());
    }

    @Override
    public CMQTopicEvent clone() {
        try {
            return (CMQTopicEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
        }
    }
}
