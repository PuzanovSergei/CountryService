package guru.qu.country.controller;

import guru.qu.country.model.Country;
import guru.qu.country.service.CountryService;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/countries")
    public List<Country> getAllCountry() {
        return countryService.getAllCountry();
    }

    @PostMapping("/addNewCountry")
    public Country addNewCountry(@RequestParam String countryName, @RequestParam String countryCode) {
        return countryService.addCountry(countryName, countryCode);
    }

    @PatchMapping("/editCountry")
    public Country editCountry(@RequestParam String countryName, @RequestParam String countryCode) {
        return countryService.updateCountry(countryName, countryCode);
    }
}
