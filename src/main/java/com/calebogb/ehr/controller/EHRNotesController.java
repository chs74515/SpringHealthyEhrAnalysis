package com.calebogb.ehr.controller;

import com.calebogb.ehr.exception.EHRServiceException;
import com.calebogb.ehr.service.EHRNotesWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "ehr")
public class EHRNotesController {

    Logger logger = LoggerFactory.getLogger(EHRNotesAPIController.class);

    @Autowired
    private EHRNotesWebService ehrNotesWebService;

    @GetMapping("/pct-basic")
    public String basicEHRNotesByState(Model model) {
        try {
            model.addAttribute("ehrSummaryList", ehrNotesWebService.getPCTBasicEHRNotes());
        } catch (EHRServiceException e) {
            logger.error(e.getMessage());
        }
        return "basic-ehr-by-state";
    }
}
