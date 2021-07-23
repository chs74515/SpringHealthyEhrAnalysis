package com.calebogb.ehr.controller;

import com.calebogb.ehr.controller.response.ErrorResponse;
import com.calebogb.ehr.exception.EHRServiceException;
import com.calebogb.ehr.service.EHRNotesWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ehr-data")
public class EHRNotesAPIController {

    Logger logger = LoggerFactory.getLogger(EHRNotesAPIController.class);

    @Autowired
    private EHRNotesWebService ehrNotesWebService;

    @GetMapping(value = "pct-hospital-basic-ehr", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getPCTofBasicEHRNotes(){
        try {
            return new ResponseEntity(ehrNotesWebService.getPCTBasicEHRNotes(), HttpStatus.OK);
        } catch (EHRServiceException e) {
            logger.error(e.getMessage());
            return new ResponseEntity( new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}