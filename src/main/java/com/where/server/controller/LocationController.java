package com.where.server.controller;


import java.util.Locale;

import javax.validation.Valid;

import com.where.server.dto.LocationDto;
import com.where.server.dto.LocationListDto;
import com.where.server.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping(
        path = "where"
)
@Validated
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public void save(@RequestBody @Valid LocationListDto locationListDto) {
        locationService.save(locationListDto.getLocations());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<LocationDto> getLatest() {
        return locationService.getLatest()
                .map(locationDto -> new ResponseEntity<>(locationDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            path = "show",
            method = RequestMethod.GET
    )
    public RedirectView showLatest() {
        String url = locationService.getLatest()
                .map(locationDto -> String.format(
                        Locale.ROOT,
                        // see https://developers.google.com/maps/documentation/urls/guide#search-action
                        "https://www.google.com/maps/search/?api=1&query=%f,%f",
                        locationDto.getLatitude(), locationDto.getLongitude()))
                .orElse("show/noLocation");

        return new RedirectView(url);
    }

    @RequestMapping(
            path = "show/noLocation",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> noLocation() {
        return new ResponseEntity<>("No location yet, nothing to show", HttpStatus.NOT_FOUND);
    }
}
