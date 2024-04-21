package com.rms.resource.management.controller;

import com.rms.resource.management.domain.Customer;
import com.rms.resource.management.dto.ReturnWIthMessage;
import com.rms.resource.management.dto.customer.CUstomerUpdateData;
import com.rms.resource.management.dto.customer.CustomerRegistrationData;
import com.rms.resource.management.dto.customer.CustomerDetails;
import com.rms.resource.management.service.spec.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/customers")
public class IcoController {

  @Autowired
  private ICustomerService service;

  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<CustomerDetails>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<CustomerDetails> customers = service.findAll(pageable).map(CustomerDetails::new);

    return ResponseEntity.ok().body(customers);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ReturnWIthMessage> cadastrar(@RequestBody @Valid CustomerRegistrationData dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Customer customer = service.save(dados);
    URI uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();

    String message = getMessage("customers.create.success", locale);

    return ResponseEntity.created(uri).body(new ReturnWIthMessage(message, new CustomerDetails(customer)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> atualizar(@PathVariable Long id, @RequestBody @Valid CUstomerUpdateData dados, final Locale locale) {
    Customer customer = service.update(id, dados);
    String message = getMessage("customers.update.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new CustomerDetails(customer)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> deletar(@PathVariable Long id, final Locale locale) {
    Customer customer = service.delete(id);

    String message = getMessage("customers.delete.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new CustomerDetails(customer)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerDetails> detalhar(@PathVariable Long id) {
    Customer customer = service.findById(id);

    return ResponseEntity.ok().body(new CustomerDetails(customer));
  }
}
