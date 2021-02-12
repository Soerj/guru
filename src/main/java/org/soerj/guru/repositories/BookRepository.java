package org.soerj.guru.repositories;

import org.soerj.guru.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
