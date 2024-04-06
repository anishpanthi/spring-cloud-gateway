package net.app.order.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Provides basics operations to perform over entity.
 *
 * @param <E>  indicates entity class
 * @param <T>  indicates dto class for entity
 * @param <ID> indicates primary key type
 * @author Anish Panthi
 */
public interface BaseService<E, T, ID> {

  Optional<T> findOne(ID id);

  List<E> findAll();

  T create(T t);

  void delete(ID id);

  T update(T t);

  default Page<T> findAll(Pageable pageable) {
    return null;
  }

}
