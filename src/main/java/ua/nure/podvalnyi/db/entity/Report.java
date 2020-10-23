package ua.nure.podvalnyi.db.entity;

import java.util.Objects;

public class Report {

    private Long id;
    private String topic;

    public Report(Long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public Report(String topic) {
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id.equals(report.id) &&
                topic.equals(report.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", topic='" + topic + '\'' +

                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
