package com.zavgorodniy.test1;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private String name;
    private String age;

    public Model(String name, String age) {
        this.name = name;
        this.age = age;
    }

    private Model(Parcel parcel) {
        name = parcel.readString();
        age = parcel.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
