package com.liu.springCloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfo {

    private String name;
    private Integer age;



    public HouseInfo(String name){
        this.name=name;
    }

}
