package services;

import javax.persistence.EntityManager;

class PersistanceService {

  EntityManager entityManager;

  PersistanceService(EntityManager entityManager){
    this.entityManager = entityManager;
  }
}
