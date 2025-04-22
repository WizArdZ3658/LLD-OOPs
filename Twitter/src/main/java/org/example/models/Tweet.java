package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Tweet {
    private Integer id;
    private User user;
    private String message;
    private List<String> attachments;
    private Date createdAt;
}
