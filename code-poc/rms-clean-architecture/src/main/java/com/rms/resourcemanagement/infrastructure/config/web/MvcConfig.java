package com.rms.resourcemanagement.infrastructure.config.web;

import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.infrastructure.admin.gateway.AdminDatabaseGateway;
import com.rms.resourcemanagement.infrastructure.ico.gateway.IcoDatabaseGateway;
import com.rms.resourcemanagement.infrastructure.config.db.repository.AdminRepository;
import com.rms.resourcemanagement.infrastructure.config.db.repository.IcoRepository;
import com.rms.resourcemanagement.infrastructure.config.db.repository.RentalRepository;
import com.rms.resourcemanagement.infrastructure.config.db.repository.RentalCompanyRepository;
import com.rms.resourcemanagement.infrastructure.rental.gateway.RentalDatabaseGateway;
import com.rms.resourcemanagement.infrastructure.baselocation.gateway.BaseLocationDatabaseGateway;
import com.rms.resourcemanagement.usecase.admin.*;
import com.rms.resourcemanagement.usecase.ico.*;
import com.rms.resourcemanagement.usecase.rental.*;
import com.rms.resourcemanagement.usecase.baselocation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.ResourceBundle;

@Configuration
public class MvcConfig {

  @Bean
  public ResourceBundle messageBundle() {
    return ResourceBundle.getBundle("ValidationMessages");
  }

  @Bean
  public LocaleResolver sessionLocaleResolver() {
    return new AcceptHeaderResolver();
  }

  @Bean
  public CreateIcoUseCase createCustomerUseCase(IcoRepository customerRepository) {
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);
    return new CreateIcoUseCase(customerGateway);
  }

  @Bean
  public GetIcoUseCase getCustomerUseCase(IcoRepository customerRepository) {
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);
    return new GetIcoUseCase(customerGateway);
  }

  @Bean
  public SearchIcoUseCase searchCustomerUseCase(IcoRepository customerRepository) {
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);
    return new SearchIcoUseCase(customerGateway);
  }

  @Bean
  public UpdateIcoUseCase updateCustomerUseCase(IcoRepository customerRepository) {
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);
    return new UpdateIcoUseCase(customerGateway);
  }

  @Bean
  public DeleteIcoUseCase deleteCustomerUseCase(IcoRepository customerRepository) {
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);
    return new DeleteIcoUseCase(customerGateway);
  }

  @Bean
  public CreateBaseLocationUseCase createRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    return new CreateBaseLocationUseCase(rentalCompanyGateway);
  }

  @Bean
  public GetBaseLocationUseCase getRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    return new GetBaseLocationUseCase(rentalCompanyGateway);
  }

  @Bean
  public SearchBaseLocationUseCase searchRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    return new SearchBaseLocationUseCase(rentalCompanyGateway);
  }

  @Bean
  public UpdateBaseLocationUseCase updateRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    return new UpdateBaseLocationUseCase(rentalCompanyGateway);
  }

  @Bean
  public DeleteBaseLocationUseCase deleteRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    return new DeleteBaseLocationUseCase(rentalCompanyGateway);
  }

  @Bean
  public FindBaseLocationsByCityUseCase findRentalCompaniesByCityUseCase(RentalCompanyRepository rentalCompanyRepository) {
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    return new FindBaseLocationsByCityUseCase(rentalCompanyGateway);
  }

  @Bean
  public CreateAdminUseCase createAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new CreateAdminUseCase(adminGateway);
  }

  @Bean
  public GetAdminUseCase getAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new GetAdminUseCase(adminGateway);
  }

  @Bean
  public SearchAdminUseCase searchAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new SearchAdminUseCase(adminGateway);
  }

  @Bean
  public UpdateAdminUseCase updateAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new UpdateAdminUseCase(adminGateway);
  }

  @Bean
  public DeleteAdminUseCase deleteAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new DeleteAdminUseCase(adminGateway);
  }

  @Bean
  public DeleteRentalUseCase deleteRentalUseCase(RentalRepository rentalRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    return new DeleteRentalUseCase(rentalGateway);
  }

  @Bean
  public CreateRentalUseCase createRentalUseCase(RentalRepository rentalRepository, RentalCompanyRepository rentalCompanyRepository, IcoRepository customerRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);

    return new CreateRentalUseCase(rentalGateway, rentalCompanyGateway, customerGateway);
  }

  @Bean
  public GetRentalUseCase getRentalUseCase(RentalRepository rentalRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    return new GetRentalUseCase(rentalGateway);
  }

  @Bean
  public ListRentalsByBaseLocationUseCase listRentalsByRentalCompanyUseCase(RentalRepository rentalRepository, RentalCompanyRepository rentalCompanyRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    BaseLocationGateway rentalCompanyGateway = new BaseLocationDatabaseGateway(rentalCompanyRepository);

    return new ListRentalsByBaseLocationUseCase(rentalGateway, rentalCompanyGateway);
  }

  @Bean
  public ListRentalsByIcoUseCase listRentalsByCustomerUseCase(RentalRepository rentalRepository, IcoRepository customerRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    IcoGateway customerGateway = new IcoDatabaseGateway(customerRepository);

    return new ListRentalsByIcoUseCase(rentalGateway, customerGateway);
  }

  @Bean
  public SearchRentalsUseCase searchRentalsUseCase(RentalRepository rentalRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    return new SearchRentalsUseCase(rentalGateway);
  }
}
