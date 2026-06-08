package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})

public class Customer {

        @Id
        @Column(name = "customer_id",length=45)
        @GeneratedValue(strategy =GenerationType.AUTO)
        private int customerId;

        @Column(name="customer_name",length =100,nullable = false )
        private String customerName;

        @Column(name="customer_address",length =200 )
        private String customerAddress;

        @Type(type="json")
        @Column(name = "customer_contact_numbers",length =200,columnDefinition = "json")
        private List<String> contactNumbers;

        @Column(name = "customer_salary",length = 200)
        private double customerSalary;

        @Column(name = "nic")
        private String nic;

        @Column(name="active_state",columnDefinition = "TINYINT default 1")
        private boolean activeState;


        @OneToMany(mappedBy ="customer")
        private Set<Order> orders;

        public Customer() {
        }

        public Customer(int customerId, String customerName, String customerAddress, List<String> contactNumbers, double customerSalary, String nic, boolean activeState, Set<Order> orders) {
                this.customerId = customerId;
                this.customerName = customerName;
                this.customerAddress = customerAddress;
                this.contactNumbers = contactNumbers;
                this.customerSalary = customerSalary;
                this.nic = nic;
                this.activeState = activeState;
                this.orders = orders;
        }

        public Customer(int customerId, String customerName, String customerAddress, List<String> contactNumbers, double customerSalary, String nic, boolean activeState) {
                this.customerId = customerId;
                this.customerName = customerName;
                this.customerAddress = customerAddress;
                this.contactNumbers = contactNumbers;
                this.customerSalary = customerSalary;
                this.nic = nic;
                this.activeState = activeState;
        }

        public int getCustomerId() {
                return customerId;
        }

        public void setCustomerId(int customerId) {
                this.customerId = customerId;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        public String getCustomerAddress() {
                return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
                this.customerAddress = customerAddress;
        }

        public List<String> getContactNumbers() {
                return contactNumbers;
        }

        public void setContactNumbers(List<String> contactNumbers) {
                this.contactNumbers = contactNumbers;
        }

        public double getCustomerSalary() {
                return customerSalary;
        }

        public void setCustomerSalary(double customerSalary) {
                this.customerSalary = customerSalary;
        }

        public String getNic() {
                return nic;
        }

        public void setNic(String nic) {
                this.nic = nic;
        }

        public boolean isActiveState() {
                return activeState;
        }

        public void setActiveState(boolean activeState) {
                this.activeState = activeState;
        }

        public Set<Order> getOrders() {
                return orders;
        }

        public void setOrders(Set<Order> orders) {
                this.orders = orders;
        }

        @Override
        public String toString() {
                return "Customer{" +
                        "customerId=" + customerId +
                        ", customerName='" + customerName + '\'' +
                        ", customerAddress='" + customerAddress + '\'' +
                        ", contactNumbers=" + contactNumbers +
                        ", customerSalary=" + customerSalary +
                        ", nic='" + nic + '\'' +
                        ", activeState=" + activeState +

                        '}';
        }
}
