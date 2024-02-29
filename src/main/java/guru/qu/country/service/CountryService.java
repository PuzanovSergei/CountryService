package guru.qu.country.service;

import guru.qu.country.data.CountryEntity;
import guru.qu.country.data.CountryRepository;
import guru.qu.country.model.Country;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountry() {
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }

    public Country addCountry(@Nonnull String countryName, @Nonnull String countryCode) {
        return Country.fromEntity(
                countryRepository.save(
                        Country.fromJson(new Country(countryName, countryCode))));
    }

    public Country updateCountry(@Nonnull String countryName, @Nonnull String countryCode) {
        CountryEntity country = countryRepository.findByCountryCode(countryCode);
        country.setCountryName(countryName);
        return Country.fromEntity(country);
    }
}
