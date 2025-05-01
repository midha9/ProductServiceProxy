package org.spring.productserviceproxy.repostries;

import org.spring.productserviceproxy.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories, Long> {

    Categories save(Categories categories);
}