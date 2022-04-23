package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Country;
import mk.ukim.finki.emt.lab2.repository.CountryRepository;
import mk.ukim.finki.emt.lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {

        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Country create(String name, String continent) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Country c = new Country(name,continent);
        countryRepository.save(c);
        return c;
    }

    @Override
    public Country update(String name, String continent) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Country c = new Country(name,continent);
        countryRepository.save(c);
        return c;
    }

    @Override
    public void delete(String name) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        countryRepository.deleteByName(name);
    }
}
