package com.tantai.dacnpm.request;

import lombok.Data;

@Data
public class UserDeleteRequest {
    private String eMail;
    private String password;
}
