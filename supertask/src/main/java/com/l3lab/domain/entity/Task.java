package com.l3lab.domain.entity;

import com.l3lab.domain.DomainAudit;
import com.l3lab.domain.valueobject.TaskStatus;
import lombok.Data;

import javax.persistence.*;

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
public class Task extends DomainAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String detail;
    private TaskStatus taskStatus;

    public Task() {
        super();
        taskStatus = TaskStatus.CREATED;
    }

    public void finish() {
        this.setTaskStatus(TaskStatus.DONE);
    }
}
