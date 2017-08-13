package com.where.server.dto;


import java.util.List;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;


// I want to be able to save lists of locations, but Bean Validation doesn't support validation
// of List<X> nicely as it is not a Java Bean. The solution is to create a wrapper Bean with a
// a List field and use that in the API for validation, and just fetch the list afterwards.
@Getter
@Setter
public class LocationListDto {

    @Valid
    private List<LocationDto> locations;
}
