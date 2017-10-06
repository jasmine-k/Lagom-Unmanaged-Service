package com.example.hello.user.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;

@JsonDeserialize
public final class UserData {
    /*public Integer userId;
    public Integer id;
    public String title;
    public String body;*/

    @JsonProperty("userId")
    public Integer userId;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("body")
    public String body;
 /*   public GreetingMessage(String message) {
        this.message = Preconditions.checkNotNull(message, "message");
    }
*/
   /* @JsonCreator
    public UserData( Integer userId, Integer id, String title, String body) {

        this.userId = Preconditions.checkNotNull(userId, "userId");
        this.id = Preconditions.checkNotNull(id, "id");
        this.title = Preconditions.checkNotNull(title, "title");
        this.body = Preconditions.checkNotNull(body, "body");
    }
*/
    @JsonCreator
    public UserData(){

    }
}
