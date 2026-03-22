package com.sam.socialmediaapp.Request;

import com.sam.socialmediaapp.models.Chat;
import com.sam.socialmediaapp.models.User;
import lombok.Data;

@Data
public class CreateChatRequest {
    private Integer userid;
}
