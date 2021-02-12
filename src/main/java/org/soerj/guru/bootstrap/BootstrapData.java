package org.soerj.guru.bootstrap;

import org.soerj.guru.domain.Author;
import org.soerj.guru.domain.Book;
import org.soerj.guru.domain.Publisher;
import org.soerj.guru.repositories.AuthorRepository;
import org.soerj.guru.repositories.BookRepository;
import org.soerj.guru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Cartman");
        Book potter = new Book("Potter", "1231");
        Publisher vasya = new Publisher("Vasya", "Pushkina street, Kolotushkina, Moscow, 111116");
        potter.getPublishers().add(vasya);
        vasya.getBooks().add(potter);
        publisherRepository.save(vasya);
        eric.getBooks().add(potter);
        potter.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(potter);

        Author patty = new Author("Patty", "Pro");
        Book cookbook = new Book("Dish", "234234");
        patty.getBooks().add(cookbook);
        cookbook.getAuthors().add(patty);
        authorRepository.save(patty);
        bookRepository.save(cookbook);

        System.out.println("Bootstrap...");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publishers count: " + publisherRepository.count());
    }
}
