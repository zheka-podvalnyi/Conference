package ua.nure.podvalnyi.db.entity;

import java.util.Objects;

public class Statistic {

   private Long userId;
   private Long eventId;
   private boolean userStatus;

    public Statistic(Long userId, Long eventId, boolean userStatus) {
        this.userId = userId;
        this.eventId = eventId;
        this.userStatus = userStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return userStatus == statistic.userStatus &&
                Objects.equals(userId, statistic.userId) &&
                Objects.equals(eventId, statistic.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, eventId, userStatus);
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "userId=" + userId +
                ", eventId=" + eventId +
                ", user_status=" + userStatus +
                '}';
    }
}
