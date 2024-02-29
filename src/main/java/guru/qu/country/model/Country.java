package guru.qu.country.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import guru.qu.country.data.CountryEntity;

public record Country(@JsonProperty("country_name") String countryName,
                      @JsonProperty("country_code") String countryCode) {

    public static Country fromEntity(CountryEntity entity) {
        return new Country(entity.getCountryName(), entity.getCountryCode());
    }

    public static CountryEntity fromJson(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryCode(country.countryCode);
        countryEntity.setCountryName(country.countryName);
        return countryEntity;
    }
}
