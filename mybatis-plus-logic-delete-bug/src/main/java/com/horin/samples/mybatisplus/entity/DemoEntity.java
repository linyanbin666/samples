package com.horin.samples.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("demo_entity")
public class DemoEntity extends BaseEntity {

    /**
     * demo
     */
    private String demo;

}
