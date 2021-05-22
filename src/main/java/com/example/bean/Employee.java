package com.example.bean;

import lombok.*;

import java.util.Date;

/**
 * @user KyZhang
 * @date
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private Date bir;
}
