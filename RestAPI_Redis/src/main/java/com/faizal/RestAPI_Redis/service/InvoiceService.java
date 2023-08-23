package com.faizal.RestAPI_Redis.service;

import com.faizal.RestAPI_Redis.model.Invoice;

import java.util.List;

public interface InvoiceService {

    public Invoice saveInvoice(Invoice invoice);
    public Invoice updateInvoice(Invoice inv,Integer invId);
    public void deleteInvoice(Integer invId);
    public Invoice getOneInvoice(Integer invId);
    public List<Invoice> getAllInvoices();
}
