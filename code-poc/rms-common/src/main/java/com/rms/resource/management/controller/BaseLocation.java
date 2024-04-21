package com.rms.resource.management.controller;

import com.rms.resource.management.dto.ReturnWIthMessage;
import com.rms.resource.management.dto.baseLocation.BaseLocationUpdateData;
import com.rms.resource.management.dto.baseLocation.BaseLocationRegistrationData;
import com.rms.resource.management.dto.baseLocation.BaseLocationDetails;
import com.rms.resource.management.dto.baseLocation.BaseLocationListingCitiesData;
import com.rms.resource.management.service.spec.IBaseLocationService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/locadoras")
public class BaseLocation {

  @Autowired
  private IBaseLocationService service;

  @Getter
  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<BaseLocationDetails>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<BaseLocationDetails> locadoras = service.findAll(pageable).map(BaseLocationDetails::new);

    return ResponseEntity.ok().body(locadoras);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ReturnWIthMessage> cadastrar(@RequestBody @Valid BaseLocationRegistrationData dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    com.rms.resource.management.domain.BaseLocation rentalCompany = service.save(dados);
    URI uri = uriBuilder.path("/locadoras/{id}").buildAndExpand(rentalCompany.getId()).toUri();

    String message = getMessage("locadoras.create.success", locale);

    return ResponseEntity.created(uri).body(new ReturnWIthMessage(message, new BaseLocationDetails(rentalCompany)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> atualizar(@PathVariable Long id, @RequestBody @Valid BaseLocationUpdateData dados, final Locale locale) {
    com.rms.resource.management.domain.BaseLocation rentalCompany = service.update(id, dados);
    String message = getMessage("locadoras.update.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new BaseLocationDetails(rentalCompany)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> deletar(@PathVariable Long id, final Locale locale) {
    com.rms.resource.management.domain.BaseLocation rentalCompany = service.delete(id);

    String message = getMessage("locadoras.delete.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new BaseLocationDetails(rentalCompany)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<BaseLocationDetails> detalhar(@PathVariable Long id) {
    com.rms.resource.management.domain.BaseLocation rentalCompany = service.findById(id);

    return ResponseEntity.ok().body(new BaseLocationDetails(rentalCompany));
  }

  @GetMapping("/cidades")
  public ResponseEntity<BaseLocationListingCitiesData> listarCidades() {
    List<String> cidades = service.findAllCities();

    return ResponseEntity.ok().body(new BaseLocationListingCitiesData(cidades));
  }

  @GetMapping("/cidades/{cidade}")
  public ResponseEntity<Page<BaseLocationDetails>> listarTodasPorCidade(@PathVariable String cidade, @PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    // Não é necessário tratar cidade nula pois, nesse caso, não será mapeado para esse método.
    Page<BaseLocationDetails> locadoras = service.findAllByCity(cidade, pageable).map(BaseLocationDetails::new);

    return ResponseEntity.ok().body(locadoras);
  }
}
