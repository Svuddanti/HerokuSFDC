package com.force.example.fulfillment.order.service;

import java.util.List;

<<<<<<< HEAD
=======
import canvas.CanvasRequest;
>>>>>>> fd7926607775eee4ae38593821088a0316340ab5
import org.springframework.stereotype.Service;

import com.force.api.ApiSession;
import com.force.api.ForceApi;
import com.force.api.QueryResult;
import com.force.sdk.oauth.context.ForceSecurityContextHolder;
import com.force.sdk.oauth.context.SecurityContext;

import com.force.example.fulfillment.order.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

<<<<<<< HEAD
    private ForceApi getForceApi() {
        SecurityContext sc = ForceSecurityContextHolder.get();

        ApiSession s = new ApiSession();
        s.setAccessToken(sc.getSessionId());
        s.setApiEndpoint(sc.getEndPointHost());

=======
    private CanvasRequest cr;

    private ForceApi getForceApi() {
        ApiSession s = new ApiSession();

        if(cr != null) {
            s.setAccessToken(cr.getClient().getOAuthToken());
            s.setApiEndpoint(cr.getClient().getInstanceUrl());
        } else {
            SecurityContext sc = ForceSecurityContextHolder.get();
            s.setAccessToken(sc.getSessionId());
            s.setApiEndpoint(sc.getEndPointHost());
        }
>>>>>>> fd7926607775eee4ae38593821088a0316340ab5
        return new ForceApi(s);
    }
    
	@Override
	public void addInvoice(Invoice invoice) {
        getForceApi().createSObject("Invoice__c", invoice);
	}

	@Override
	public List<Invoice> listInvoices() {
        QueryResult<Invoice> res = getForceApi().query("SELECT Id, Name, Status__c FROM Invoice__c", Invoice.class);
        return res.getRecords();
	}

	@Override
	public Invoice findInvoice(String id) {
		return getForceApi().getSObject("Invoice__c", id).as(Invoice.class);
	}

	@Override
	public void removeInvoice(String id) {
        getForceApi().deleteSObject("Invoice__c", id);
    }

<<<<<<< HEAD
=======
    public void setSignedRequest(CanvasRequest canRequest) {
        this.cr = canRequest;
    }

>>>>>>> fd7926607775eee4ae38593821088a0316340ab5
}
