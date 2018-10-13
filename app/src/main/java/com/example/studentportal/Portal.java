package com.example.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Dit object bevat een url en een titel
 */
public class Portal implements Parcelable {
    private String url;
    private String titel;

    public Portal(String url, String titel) {
        this.url = url;
        this.titel = titel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.titel);
    }

    protected Portal(Parcel in) {
        this.url = in.readString();
        this.titel = in.readString();
    }

    public static final Parcelable.Creator<Portal> CREATOR = new Parcelable.Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel source) {
            return new Portal(source);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };
}
