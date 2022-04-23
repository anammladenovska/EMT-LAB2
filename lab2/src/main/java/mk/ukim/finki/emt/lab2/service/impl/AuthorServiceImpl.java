package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Country;
import mk.ukim.finki.emt.lab2.repository.AuthorRepository;
import mk.ukim.finki.emt.lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Author create(String name, String surname, Country country) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Author author = new Author(name,surname,country);
        authorRepository.save(author);
        return author;
    }

    @Override
    public Author update(String name, String surname, Country country) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Author author = new Author(name,surname,country);
        authorRepository.save(author);
        return author;
    }

    @Override
    public void delete(String name) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        authorRepository.deleteByName(name);
    }
}
