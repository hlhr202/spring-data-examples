package com.example.person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonCustomRepositoryImpl implements PersonCustomRepository {
    private final EntityManager em;

    public PersonCustomRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Person> findThatPerson() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);

        Root<Person> root = cq.from(Person.class);
        cq.where(cb.equal(root.get("firstName"), "First"));

        TypedQuery<Person> query = em.createQuery(cq);
        return query.getResultList();
    }
}
