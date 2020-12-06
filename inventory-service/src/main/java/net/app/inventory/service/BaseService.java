package net.app.inventory.service;

import java.util.List;
import java.util.Optional;
import net.app.inventory.dto.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Provides basics operations to perform over entity.
 *
 * @param <E>  indicates entity class
 * @param <T>  indicates dto class for entity
 * @param <ID> indicates primary key type
 *
 * @author Anish Panthi
 */
public interface BaseService<E, T, ID> {

  Optional<T> findOne(ID id);

  List<E> findAll();

  T create(T t);

  ApiResponse delete(T t);

  T update(T t);

  default Page<T> findAll(Pageable pageable){
    return null;
  }

}
