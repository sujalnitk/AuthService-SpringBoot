package org.example.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.example.entity.Userinfo;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends Userinfo
{
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
}
