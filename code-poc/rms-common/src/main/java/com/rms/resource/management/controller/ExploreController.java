package com.rms.resource.management.controller;

import com.rms.resource.management.dto.baseLocation.BaseLocationPublicListingData;
import com.rms.resource.management.service.spec.IBaseLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explorar")
public class ExploreController {

  @Autowired
  private IBaseLocationService service;

  @GetMapping
  public ResponseEntity<Page<BaseLocationPublicListingData>> listar(@RequestParam(required = false) String city,
                                                                    @PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
    Page<BaseLocationPublicListingData> locadoras;
    if (city != null && !city.isEmpty()) {
      locadoras = service.findAllByCity(city, pageable).map(BaseLocationPublicListingData::new);
    } else {
      locadoras = service.findAll(pageable).map(BaseLocationPublicListingData::new);
    }

    return ResponseEntity.ok().body(locadoras);
  }


}
