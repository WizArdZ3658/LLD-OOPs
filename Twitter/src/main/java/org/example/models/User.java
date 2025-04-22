package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String profilePicture;
    private String coverPicture;
    private List<User> followers;
    private List<User> following;
    private List<Tweet> postedTweets;

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
