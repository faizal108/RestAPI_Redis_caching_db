package com.faizal.RestAPI_Redis.controller;

import com.faizal.RestAPI_Redis.model.Invoice;
import com.faizal.RestAPI_Redis.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis/v1/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/saveInv")
    public Invoice saveInvoice(@RequestBody Invoice inv){
        return invoiceService.saveInvoice(inv);
    }

    @GetMapping("/allInv")
    public ResponseEntity<List<Invoice>> getAllInvoice(){
         return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/getOne/{invId}")
    public Invoice getOneInvoice(@PathVariable Integer invId){
        return invoiceService.getOneInvoice(invId);
    }

    @PutMapping("/modify/{invId}")
    public Invoice updateInvoice(@RequestBody Invoice invoice,@PathVariable Integer invId){
        return invoiceService.updateInvoice(invoice,invId);
    }

    @DeleteMapping("/delete/{invId}")
    public String deleteInvoice(@PathVariable Integer invId){
        invoiceService.deleteInvoice(invId);
        return "Invoice with Id : "+ invId +" Deleted !";
    }
}
