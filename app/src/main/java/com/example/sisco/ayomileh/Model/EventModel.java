package com.example.sisco.ayomileh.Model;

import java.util.ArrayList;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class EventModel {
    private String id;
    private String name;
    private String address;
    private String region;
    private String date;
    private String time;
    private String total;
    private String type;

    public EventModel(String id, String name, String address, String region, String date, String time) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.region = region;
        this.date = date;
        this.time = time;
    }

    public EventModel(String id, String name, String address, String region, String date, String time, String total, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.region = region;
        this.date = date;
        this.time = time;
        this.total = total;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<EventModel> createEvent(){
        ArrayList<EventModel> eventModels = new ArrayList<>();

        eventModels.add(new EventModel("1", "PMI Kota Batu", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Batu", "26 Oktober 2016", "07.00 - 09.00"));
        eventModels.add(new EventModel("2", "PMI Lawang", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Batu", "26 Oktober 2016", "07.00 - 09.00"));
        eventModels.add(new EventModel("3", "PMI Kota Malang", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Batu", "26 Oktober 2016", "07.00 - 09.00"));
        eventModels.add(new EventModel("4", "PMI Kabupaten Malang", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Batu", "26 Oktober 2016", "07.00 - 09.00"));
        return eventModels;
    }

    public static ArrayList<EventModel> createHistory(){
        ArrayList<EventModel> eventModels = new ArrayList<>();

        eventModels.add(new EventModel("1", "PMI Kota Batu", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Batu", "26 Oktober 2016", "07.00 - 09.00", "0", "event"));
        eventModels.add(new EventModel("2", "RS Saiful Anwar", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Malang", "26 Oktober 2016", "07.00 - 09.00", "3", "donor"));
        eventModels.add(new EventModel("3", "PMI Kota Batu", "Jl. Kenangan tak terbatas RT 4 RW 12, Oro-oro Ombo", "Kota Batu", "26 Oktober 2016", "07.00 - 09.00", "0", "event"));
        return eventModels;
    }
}
