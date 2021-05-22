package com.example.bean;

import lombok.*;

/**
 * @user KyZhang
 * @date
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private String sex;

}
