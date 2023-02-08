package com.assigment.repository;

import java.util.List;

import com.assigment.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query(value = " SELECT t.* "
            + " FROM account a "
            + " INNER JOIN transaction t "
            + " ON (t.account_id = a.id) "
            + " WHERE a.customer_id = :customerId ", nativeQuery = true)
    List<Transaction> getAllByCustomerId(long customerId);
}
