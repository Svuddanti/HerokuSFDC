package com.force.example.fulfillment.order.service;

import java.util.List;

<<<<<<< HEAD
=======
import canvas.CanvasRequest;
>>>>>>> fd7926607775eee4ae38593821088a0316340ab5
import com.force.example.fulfillment.order.model.Invoice;

public interface InvoiceService {
	public void addInvoice(Invoice invoice);
    public List<Invoice> listInvoices();
    public Invoice findInvoice(String id);
    public void removeInvoice(String id);
<<<<<<< HEAD
=======
    public void setSignedRequest(CanvasRequest cr);
>>>>>>> fd7926607775eee4ae38593821088a0316340ab5
}
