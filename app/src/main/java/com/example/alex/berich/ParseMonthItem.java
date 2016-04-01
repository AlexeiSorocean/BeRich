package com.example.alex.berich;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Alex on 1/22/2016.
 */
@ParseClassName("ParseMonthItem")
public class ParseMonthItem extends ParseObject {

    public ParseMonthItem() {
        super();
    }

    // Add a constructor that contains core properties
    public ParseMonthItem(String body) {
        super();
        setBody(body);
    }

    // Use getString and others to access fields
    public String getBody() {
        return getString("body");
    }

    // Use put to modify field values
    public void setBody(String value) {
        put("body", value);
    }

    // Get the user for this item
    public ParseUser getUser()  {
        return getParseUser("owner");
    }

    // Associate each item with a user
    public void setOwner(ParseUser user) {
        //put("owner", user);
    }
}
