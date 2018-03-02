package com.darsideofthedev.resttemplate.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Hobbies {


    private List<Hobby> hobby;

    public List<Hobby> getHobbies() {
        return hobby;
    }

    @XmlElement(name = "hobby")
    public void setHobbies(List<Hobby> hobbies) {
        this.hobby = hobbies;
    }
}
