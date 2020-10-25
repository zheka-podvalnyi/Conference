package ua.nure.podvalnyi.db.entity;

import java.sql.Date;
import java.util.Objects;

public class RequestDto {

    private Long userId;
    private String userName;
    private String userMiddleName;
    private String userLastName;
    private String userLogin;
    private Long eventId;
    private Date eventDate;
    private String eventPlace;
    private String eventName;
    private String topic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDto that = (RequestDto) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userMiddleName, that.userMiddleName) &&
                Objects.equals(userLastName, that.userLastName) &&
                Objects.equals(userLogin, that.userLogin) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(eventDate, that.eventDate) &&
                Objects.equals(eventPlace, that.eventPlace) &&
                Objects.equals(eventName, that.eventName) &&
                Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userMiddleName, userLastName, userLogin, eventId, eventDate, eventPlace, eventName, topic);
    }

    public RequestDto(Long userId, String userName, String userMiddleName, String userLastName, String userLogin, Long eventId, Date eventDate, String eventPlace, String eventName, String topic) {
        this.userId = userId;
        this.userName = userName;
        this.userMiddleName = userMiddleName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.eventName = eventName;
        this.topic = topic;

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", eventId=" + eventId +
                ", eventDate=" + eventDate +
                ", eventPlace='" + eventPlace + '\'' +
                ", eventName='" + eventName + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
