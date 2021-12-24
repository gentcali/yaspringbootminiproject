package com.gent.miniproject.customersupportservice.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customersupport {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long customersupportid;
        private long customerid;
        private String priority;
        private String comment;
        private String Status;

        /*
    // https://www.baeldung.com/jpa-persisting-enums-in-jpa

    public enum Priority {
        LOW, MEDIUM, HIGH;
    }
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

        */

        public long getCustomersupportid() {
                return customersupportid;
        }

        public void setCustomersupportid(long customersupportid) {
                this.customersupportid = customersupportid;
        }

        public long getCustomerid() {
                return customerid;
        }

        public void setCustomerid(long customerid) {
                this.customerid = customerid;
        }

        public String getPriority() {
                return priority;
        }

        public void setPriority(String priority) {
                this.priority = priority;
        }

        public String getComment() {
                return comment;
        }

        public void setComment(String comment) {
                this.comment = comment;
        }

        public String getStatus() {
                return Status;
        }

        public void setStatus(String status) {
                Status = status;
        }
}
