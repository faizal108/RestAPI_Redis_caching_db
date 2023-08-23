package com.faizal.RestAPI_Redis.repository;

import com.faizal.RestAPI_Redis.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
