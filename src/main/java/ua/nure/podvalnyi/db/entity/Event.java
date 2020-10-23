package ua.nure.podvalnyi.db.entity;

import java.sql.Date;
import java.util.Objects;

public class Event {

    private Long id;
    private Date date;
    private String place;
    private String name;

    public Event( Date date,String place,String name) {

        this.date = date;
        this.place = place;
        this.name=name;
    }

    public Event(Long id, Date date,String place, String name) {
        this.id = id;
        this.date = date;
        this.place = place;
        this.name=name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(date, event.date) &&
                Objects.equals(place, event.place) &&
                Objects.equals(name, event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, place, name);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
