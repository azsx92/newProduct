package com.frankit.product_v1.util.push;

import java.util.HashMap;
import java.util.Map;

public class PushParam {

    public PushParam putNotification(String name, Object value) {
        this.notification.put(name, value);
        return this;
    }
    public PushParam putData(String name, Object value) {
        this.data.put(name, value);
        return this;
    }

    public Map<String, Object> getNotification() {
        return notification;
    }

    public void setNotification(Map<String, Object> notification) {
        this.notification = notification;
    }

    public PushParam() {
    }

    public PushParam(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> toString(String a){
        this.message.put("token", token);
        this.message.put("notification", notification);

        Map<String,Object> map = new HashMap<>();
        map.put("message", message);
        return map;
    }

    private String token;
    private Map<String, Object> message = new HashMap<>();
    private Map<String, Object> notification = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();
}
