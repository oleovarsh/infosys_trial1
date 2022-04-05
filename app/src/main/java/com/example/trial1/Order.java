package com.example.trial1;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties // ignore class fields not mapped to properties
public class Order {

    public String location;
    public String vendor;


    public Order() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Order(
            String location, String vendor   ) {
        this.location = location;
        this.vendor = vendor;

    }



    @Exclude // excludes field from database
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("location", location);
        result.put("vendor", vendor);

        return result;
    }

}
