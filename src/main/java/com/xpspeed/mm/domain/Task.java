package com.xpspeed.mm.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

/**
 * @author edwardsbean
 * @date 15-7-15
 */
public class Task {
    @ApiModelProperty("推广任务ID")
    @Id
    String id;

    @ApiModelProperty("包名")
    String packageName;

    @ApiModelProperty("任务名称")
    String name;

    @ApiModelProperty("推广链接")
    String url;

    Integer count;

    Integer weight;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Task{" +
                "weight=" + weight +
                ", count=" + count +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
