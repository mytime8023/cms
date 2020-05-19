package com.cxy.bmsmongodb.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author chenxy
 * @date 2020/5/14 16:57
 * @desc this is description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("book")
public class Book  implements Serializable {

    @Id
    private String id;
    private Integer amount;
    private String name;
    private String info;
    private String publish;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private Double price;
}
