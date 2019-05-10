package com.example.android.imagescroller;

import android.net.Uri;

public class ImageUpload {
    String name;
    String uri;

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
    ImageUpload(String n,String u)
    {
        this.name=n;
        this.uri=u;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
