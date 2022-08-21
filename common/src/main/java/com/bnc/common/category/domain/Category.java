package com.bnc.common.category.domain;

import com.bnc.common.product.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_item", // 조인테이블명
            joinColumns = @JoinColumn(name = "category_id"), //외래키
            inverseJoinColumns = @JoinColumn(name = "product_id")) // 반대 엔티티 외래키
    List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //all 상위 엔터티에서 하위 엔터티로 모든 작업을 전파
    @JoinColumn(name = "parent_id")
    Category parent;

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> child = new ArrayList<>();

    public Category(String name) {
        checkArgument(Strings.isNotBlank(name));

        this.name = name;
    }

    public Category(String name, List<Product> products) {
        checkArgument(Strings.isNotBlank(name));

        this.name = name;
        this.products = products;
    }

    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

}
