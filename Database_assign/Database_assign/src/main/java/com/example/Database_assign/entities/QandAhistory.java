package com.example.Database_assign.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class QandAhistory {

    public class QandAhistoryId implements Serializable {

        private Long adminId;
        private Long customerId;
        private Long historyId;

        public QandAhistoryId(Long adminId, Long customerId, Long historyId) {
            this.adminId = adminId;
            this.customerId = customerId;
            this.historyId = historyId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof QandAhistoryId)) return false;
            QandAhistoryId that = (QandAhistoryId) o;
            return Objects.equals(getAdminId(), that.getAdminId()) &&
                    Objects.equals(getCustomerId(), that.getCustomerId()) &&
                    Objects.equals(getHistoryId(), that.getHistoryId());
        }

        public Long getAdminId() {
            return adminId;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public Long getHistoryId() {
            return historyId;
        }
    }

    @EmbeddedId
    private QandAhistoryId key;

    @ManyToOne
    @MapsId("adminId")
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // Link to Customer with part of the composite key
    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "Content")
    private String content;

    @Column(name = "Creation_time")
    private Date create_time;

    public QandAhistory(Admin admin, Customer customer, Long historyId, String content, Date create_time) {
        this.admin = admin;
        this.customer = customer;
        // Initialize the composite key based on both parent IDs.
        this.key = new QandAhistoryId(admin.getAccount_id(), customer.getCustomer_id(), historyId);
        this.content = content;
        this.create_time = create_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}

