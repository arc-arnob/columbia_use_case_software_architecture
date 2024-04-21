package com.rms.resourcemanagement.entity.ico.gateway;


import com.rms.resourcemanagement.entity.ico.model.Ico;

import java.util.List;
import java.util.Optional;

public interface IcoGateway {
    Ico create(Ico customer);
    Ico update(Ico customer);
    void delete(Long id);

    Optional<Ico> findById(Long id);
    Optional<Ico> findByCpf(String cpf);

    List<Ico> findAll();
}
