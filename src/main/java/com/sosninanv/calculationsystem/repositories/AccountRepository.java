package com.sosninanv.calculationsystem.repositories;

import com.sosninanv.calculationsystem.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, String> {

}
