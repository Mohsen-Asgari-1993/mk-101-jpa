package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.domain.Customer;
import ir.maktabsharif101.jpaexample.repository.CustomerRepository;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepositoryImpl;
import ir.maktabsharif101.jpaexample.service.dto.CustomerSearch;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public List<Customer> search(CustomerSearch search) {

//        select c from Customer c

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(
                getEntityClass()
        );

        Root<Customer> customerRoot = query.from(getEntityClass());

        List<Predicate> predicates = new ArrayList<>();

        addFirstNamePredicate(predicates, customerRoot, criteriaBuilder, search.getFirstName());
        addLastNamePredicate(predicates, customerRoot, criteriaBuilder, search.getLastName());
        addMobileNumberPredicate(predicates, customerRoot, criteriaBuilder, search.getMobileNumber());
        addCreateDatePredicate(predicates, customerRoot, criteriaBuilder, search.getFromDate(), search.getToDate());
        addIsActivePredicate(predicates, customerRoot, criteriaBuilder, search.getIsActive());
        addCodePredicate(predicates, customerRoot, criteriaBuilder, search.getCode());

        if (predicates.size() > 0) {
            query.where(
                    predicates.toArray(
                            new Predicate[0]
                    )
            );
        }

        return entityManager.createQuery(
                query
        ).getResultList();
    }

    private void addFirstNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                       CriteriaBuilder criteriaBuilder, String firstName) {
        if (StringUtils.isNotBlank(firstName)) {
//            c.firstName like '%:firstName%'
            predicates.add(
                    criteriaBuilder.like(
                            root.get("firstName"),
                            "%" + firstName + "%"
                    )
            );
        }
    }

    private void addLastNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                      CriteriaBuilder criteriaBuilder, String lastName) {
        if (StringUtils.isNotBlank(lastName)) {
//            c.lastName like '%:lastName%'
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"),
                            "%" + lastName + "%"
                    )
            );
        }
    }

    private void addMobileNumberPredicate(List<Predicate> predicates, Root<Customer> root,
                                          CriteriaBuilder criteriaBuilder, String mobileNumber) {
        if (StringUtils.isNotBlank(mobileNumber)) {
//            c.mobileNumber like '%:mobileNumber%'
            predicates.add(
                    criteriaBuilder.like(
                            root.get("mobileNumber"),
                            "%" + mobileNumber + "%"
                    )
            );
        }
    }

    private void addCreateDatePredicate(List<Predicate> predicates, Root<Customer> root,
                                        CriteriaBuilder criteriaBuilder, ZonedDateTime fromDate,
                                        ZonedDateTime toDate) {

        /*predicates.add(
                criteriaBuilder.between(
                        root.get("createDate"), fromDate, toDate
                )
        );*/

        if (fromDate != null) {
            predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(
                            root.get("createDate"),
                            fromDate
                    )
            );
        }
        if (toDate != null) {
            predicates.add(
                    criteriaBuilder.lessThanOrEqualTo(
                            root.get("createDate"),
                            toDate
                    )
            );
        }
    }

    private void addIsActivePredicate(List<Predicate> predicates, Root<Customer> root,
                                      CriteriaBuilder criteriaBuilder, Boolean isActive) {
        if (isActive != null) {
            /*predicates.add(
                    criteriaBuilder.equal(
                            root.get("isActive"), isActive
                    )
            );*/

            predicates.add(
                    isActive ?
                            criteriaBuilder.isTrue(root.get("isActive")) :
                            criteriaBuilder.or(
                                    criteriaBuilder.isNull(
                                            root.get("isActive")
                                    ),
                                    criteriaBuilder.isFalse(
                                            root.get("isActive")
                                    )
                            )

            );
        }
    }

    private void addCodePredicate(List<Predicate> predicates, Root<Customer> root,
                                  CriteriaBuilder criteriaBuilder, String code) {
        if (StringUtils.isNotBlank(code)) {
//            c.code like '%:code%'
            predicates.add(
                    criteriaBuilder.like(
                            root.get("code"),
                            "%" + code + "%"
                    )
            );
        }
    }
}
