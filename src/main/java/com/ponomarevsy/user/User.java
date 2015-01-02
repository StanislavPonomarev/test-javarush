package com.ponomarevsy.user;

/**
 * Created by Стас on 27.12.14.
 */

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User
{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @Column
        private String name;
        @Column
        private int age;
        @Column
        private Boolean isAdmin;
        @Column
        @Temporal(value=TemporalType.DATE)
        private Date createdDate;



        public User() {
                this.createdDate = new Date();

        }

        public User(int id, String name, int age , Boolean isAdmin)
        {
                super();
                this.id = id;
                this.name = name;
                this.age = age;
                this.isAdmin = isAdmin;
                this.createdDate = new Date();
        }
        @Override
        public String toString()
        {
                return ToStringBuilder.reflectionToString(this);
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public Boolean getIsAdmin() {
                return isAdmin;
        }

        public void setIsAdmin(Boolean isAdmin) {
                this.isAdmin = isAdmin;
        }

        public Date getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
                this.createdDate = createdDate;
        }



}
