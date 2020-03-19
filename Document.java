package com.company;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Document extends File implements Serializable {

    private String id;
    private String name;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public Document(String pathname, String id,String location) {
        super(pathname);
        this.id = id;
        this.location=location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public String getName() {
        return name;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }


}
