package com.rabbitmq.test.withspring;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wuhuachuan on 17/1/12.
 */

@Data
@ToString
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public Student(final String name){
        this.name = name;
    }
}
