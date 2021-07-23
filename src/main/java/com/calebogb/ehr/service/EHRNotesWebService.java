package com.calebogb.ehr.service;

import com.calebogb.ehr.data.PercentageEHRNotes;
import com.calebogb.ehr.exception.EHRServiceException;

import java.util.List;

public interface EHRNotesWebService {

    /**
     * This method returns sorted list of percentage of hospitals that
     * support basic ehr notes against each state
     * @return
     * @throws EHRServiceException
     */
    List<PercentageEHRNotes> getPCTBasicEHRNotes() throws EHRServiceException;

}
