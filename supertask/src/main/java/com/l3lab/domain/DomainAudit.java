package com.l3lab.domain;

import lombok.Data;

import java.util.Date;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 12:14
 * <p>
 * Desc: {描述}
 */
@Data
public class DomainAudit {
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

    public DomainAudit() {
        createDate = new Date();
        createUser = "system";

        updateDate = new Date();
        updateUser = "system";
    }
}
