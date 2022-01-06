package com.tamaraw.ypebackend.payperiod.controller;

import com.tamaraw.ypebackend.base.controller.CrudController;
import com.tamaraw.ypebackend.payperiod.model.PayPeriod;
import com.tamaraw.ypebackend.payperiod.model.PayPeriodDto;
import com.tamaraw.ypebackend.payperiod.service.PayPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payperiod")
public class PayPeriodController extends CrudController<PayPeriodDto> {

    private final PayPeriodService payPeriodService;

    @Autowired
    public PayPeriodController(PayPeriodService payPeriodService) {
        this.payPeriodService = payPeriodService;
        super.setCrudService(payPeriodService);
    }

}
