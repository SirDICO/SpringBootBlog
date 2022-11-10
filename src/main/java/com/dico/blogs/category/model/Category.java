package com.dico.blogs.category.model;


import com.dico.blogs.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String CategoryName;

    @Column(nullable = true)
    private String CategoryDetail;

    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private User user;
    private Integer user_id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryDetail() {
        return CategoryDetail;
    }

    public void setCategoryDetail(String categoryDetail) {
        CategoryDetail = categoryDetail;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
