package com.wilhelmina.reports.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BusDa001 on 12/22/2015.
 */
@Api(value = "Reports Controller")
@RestController
@RequestMapping("/ctt")
public class ReportsController {
    private static final Logger L = LoggerFactory.getLogger(ReportsController.class);



}
