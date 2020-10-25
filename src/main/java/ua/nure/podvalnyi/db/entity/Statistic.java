package ua.nure.podvalnyi.db.entity;

import java.util.Objects;

public class Statistic {

   private Long userId;
   private Long eventId;
   private boolean userStatus;
   private boolean speakerStatus;
   private String speakerTopic;
   private boolean confirm;

    public Statistic(Long userId, Long eventId, boolean userStatus) {
        this.userId = userId;
        this.eventId = eventId;
        this.userStatus = userStatus;

    }

    public Statistic(Long userId, Long eventId, boolean userStatus, boolean speakerStatus, String speakerTopic, boolean confirm) {
        this.userId = userId;
        this.eventId = eventId;
        this.userStatus = userStatus;
        this.speakerStatus = speakerStatus;
        this.speakerTopic = speakerTopic;
        this.confirm = confirm;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isSpeakerStatus() {
        return speakerStatus;
    }

    public void setSpeakerStatus(boolean speakerStatus) {
        this.speakerStatus = speakerStatus;
    }

    public String getSpeakerTopic() {
        return speakerTopic;
    }

    public void setSpeakerTopic(String speakerTopic) {
        this.speakerTopic = speakerTopic;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return userStatus == statistic.userStatus &&
                speakerStatus == statistic.speakerStatus &&
                confirm == statistic.confirm &&
                Objects.equals(userId, statistic.userId) &&
                Objects.equals(eventId, statistic.eventId) &&
                Objects.equals(speakerTopic, statistic.speakerTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, eventId, userStatus, speakerStatus, speakerTopic, confirm);
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "userId=" + userId +
                ", eventId=" + eventId +
                ", userStatus=" + userStatus +
                ", speakerStatus=" + speakerStatus +
                ", speakerTopic='" + speakerTopic + '\'' +
                ", confirm=" + confirm +
                '}';
    }
}
