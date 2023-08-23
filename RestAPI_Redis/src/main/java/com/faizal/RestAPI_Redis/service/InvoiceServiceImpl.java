package com.faizal.RestAPI_Redis.service;

import com.faizal.RestAPI_Redis.exception.InvoiceNotFoundException;
import com.faizal.RestAPI_Redis.model.Invoice;
import com.faizal.RestAPI_Redis.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    @CacheEvict(value = "allInvoice", allEntries = true)
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    @Caching(
            put = {
                    @CachePut(value = "Invoice", key = "#invId")
            },
            evict = {
                    @CacheEvict(value = "allInvoice", allEntries = true)
            }
    )
    public Invoice updateInvoice(Invoice inv, Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found!!"));
        invoice.setInvName(inv.getInvName());
        invoice.setInvAmount(inv.getInvAmount());
        return invoiceRepository.save(invoice);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "Invoice", key = "#invId"),
            @CacheEvict(value = "allInvoice", allEntries = true)
    })
//    @CacheEvict(value = "Invoice",key = "#invId") //allEntries = true instead of key for deleting all record
    public void deleteInvoice(Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found!!"));
        invoiceRepository.delete(invoice);
    }

    @Override
    @Cacheable(value = "Invoice", key = "#invId")
    public Invoice getOneInvoice(Integer invId) {
        Invoice invoice = invoiceRepository.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found!!"));
        return invoice;
    }

    @Override
    @Cacheable(value="allInvoice")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
