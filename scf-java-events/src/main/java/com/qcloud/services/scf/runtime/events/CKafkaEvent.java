package com.qcloud.services.scf.runtime.events;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Class that represents an CKafka Event
 */
public class CKafkaEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -8249023010013982243L;

    @JsonProperty(value = "Records")
    private List<Record> records;

    public static class Record implements Serializable, Cloneable {

        private static final long serialVersionUID = 3239228913688527467L;

        @JsonProperty(value = "Ckafka")
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

        private static final long serialVersionUID = -5752921621471700943L;

        private String topic;

        private Integer partition;

        private Integer offset;

        private String msgKey;

        private String msgBody;

        public MsgInfo() {}

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public Integer getPartition() {
            return partition;
        }

        public void setPartition(Integer partition) {
            this.partition = partition;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public String getMsgKey() {
            return msgKey;
        }

        public void setMsgKey(String msgKey) {
            this.msgKey = msgKey;
        }

        public String getMsgBody() {
            return msgBody;
        }

        public void setMsgBody(String msgBody) {
            this.msgBody = msgBody;
        }

        @Override
        public String toString() {
            return "MsgInfo{" +
                    "topic='" + topic + '\'' +
                    ", partition=" + partition +
                    ", offset=" + offset +
                    ", msgKey='" + msgKey + '\'' +
                    ", msgBody='" + msgBody + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MsgInfo msgInfo = (MsgInfo) o;
            return Objects.equals(getTopic(), msgInfo.getTopic()) &&
                    Objects.equals(getPartition(), msgInfo.getPartition()) &&
                    Objects.equals(getOffset(), msgInfo.getOffset()) &&
                    Objects.equals(getMsgKey(), msgInfo.getMsgKey()) &&
                    Objects.equals(getMsgBody(), msgInfo.getMsgBody());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTopic(), getPartition(), getOffset(), getMsgKey(), getMsgBody());
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

    public CKafkaEvent() {}

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
        CKafkaEvent that = (CKafkaEvent) o;
        return Objects.equals(getRecords(), that.getRecords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecords());
    }

    @Override
    public CKafkaEvent clone() {
        try {
            return (CKafkaEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
        }
    }
}
