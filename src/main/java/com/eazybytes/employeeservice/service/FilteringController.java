package com.eazybytes.employeeservice.service;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter1")
    public MappingJacksonValue filter1() {
        List<UserDetails> details = UserDetails.getDetails();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userId", "username");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserDetails", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("filter2")
    public MappingJacksonValue filter2() {
        List<UserDetails> details = UserDetails.getDetails();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("pinNumber", "username");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserDetails", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}

//@JsonIgnoreProperties(value = {"pinNumber"})
@JsonFilter("UserDetails")
class UserDetails{
    private int userId;
    private String username;
    private String pinNumber;

    public UserDetails(int userId, String username, String pinNumber) {
        this.userId = userId;
        this.username = username;
        this.pinNumber = pinNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public static List<UserDetails> getDetails() {
        return Arrays.asList(
                new UserDetails(12, "Ken", "ASWDEFR"),
                new UserDetails(13, "John", "ASEQWFRE"),
                new UserDetails(14, "pawa", "WASDEFGD"));
    }
}
