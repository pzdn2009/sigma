package com.l3lab.domain.entity;

import com.l3lab.domain.valueobject.TaskStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Summary:
 *
 * @author : zhenpeng
 *         Date: 2017-08-16
 *         Time: 10:26
 */
@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "title")
})
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String detail;
    private TaskStatus taskStatus;
    private String tags;

    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

    public Task() {
        createDate = new Date();
        createUser = "system";

        updateDate = new Date();
        updateUser = "system";

        taskStatus = TaskStatus.CREATED;
    }

    public void finish() {
        this.setTaskStatus(TaskStatus.DONE);
    }
}
