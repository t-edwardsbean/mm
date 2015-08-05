package com.xpspeed.mm.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

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

    @ApiModelProperty("推广图标,用于生成快捷方式")
    String icon;
    @DBRef
    @ApiModelProperty("推广类型,0或没有表示app,1表示网页")
    Type type;

    Integer count;

    Integer weight;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", packageName='" + packageName + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", weight=" + weight +
                '}';
    }
}
