package com.wordpress.keepup395.pro_chat;

import java.util.Date;

/**
 * Created by user on 14-06-2017.
 */

public class chatmessage {

    private String messageuser;
    private String messagetext;
    private long messagetime;

    public chatmessage(String messagetext, String messageuser) {
        this.messagetext = messagetext;
        this.messageuser = messageuser;
        messagetime = new Date().getTime();

    }

    public String getMessageuser() {
        return messageuser;
    }

    public void setMessageuser(String messageuser) {
        this.messageuser = messageuser;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public long getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(long messagetime) {
        this.messagetime = messagetime;
    }
}
