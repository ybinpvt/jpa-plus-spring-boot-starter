package com.github.yjgbg.jpa.plus.specificationSupport;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * 查询功能，模板模式
 *
 * @param <T>
 */
interface SpecExecutor<T> {

  @NotNull
  JpaSpecificationExecutor<T> getJpaSpecificationExecutor();

  @Nullable
  Sort getSort();

  @Nullable
  Specification<T> toSpecification();

  @NotNull
  default Optional<T> findOne() {
    return getJpaSpecificationExecutor().findOne(toSpecification());
  }

  @NotNull
  default List<T> findAll() {
    return getSort() == null
        ? getJpaSpecificationExecutor().findAll(toSpecification())
        : getJpaSpecificationExecutor().findAll(toSpecification(), getSort());
  }

  @NotNull
  default Page<T> findAll(int page, int size) {
    var pageReq = getSort() == null ? PageRequest.of(page, size)
        : PageRequest.of(page, size, getSort());
    return getJpaSpecificationExecutor().findAll(toSpecification(), pageReq);
  }

  default long count() {
    return getJpaSpecificationExecutor().count(toSpecification());
  }

  default boolean exist() { // 取一个看是否为空
    return !findAll(0,1).isEmpty();
  }
}