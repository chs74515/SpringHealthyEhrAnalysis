package com.calebogb.ehr.service;

import com.calebogb.ehr.data.PercentageEHRNotes;
import com.calebogb.ehr.exception.EHRServiceException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class EHRNotesWebServiceImpl implements EHRNotesWebService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${healthit.api.ehr-data}")
    private String ehrDataUrl;

    @Override
    public List<PercentageEHRNotes> getPCTBasicEHRNotes() throws EHRServiceException {
        JsonNode rootNode;
        try {
            rootNode = restTemplate.getForObject(ehrDataUrl, JsonNode.class);
        } catch (Exception e) {
            throw new EHRServiceException("An error has occurred while fetching EHR data, Unable to connect healthit API.");
        }
        List<PercentageEHRNotes> result = new ArrayList<>();
        try {
            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                JsonNode ehrJsonNode = fields.next().getValue();
                String region = ehrJsonNode.get(PercentageEHRNotes.LABEL_REGION).asText();
                if (!region.equalsIgnoreCase(PercentageEHRNotes.LABEL_NATIONAL)) {
                    String regionCode = ehrJsonNode.get(PercentageEHRNotes.LABEL_REGION_CODE).asText();
                    double pct = ehrJsonNode.get(PercentageEHRNotes.LABEL_PCT_EHR_NOTES).asDouble();
                    result.add(new PercentageEHRNotes(region, regionCode, pct));
                }
            }
        } catch (Exception e) {
            throw new EHRServiceException("An error has occurred while parsing EHR data.");
        }
        Collections.sort(result, new Comparator<PercentageEHRNotes>() {
            @Override
            public int compare(PercentageEHRNotes ehr1, PercentageEHRNotes ehr2) {
                return ehr1.getPercentage() >= ehr2.getPercentage() ? -1 : 1;
            }
        });
        return result;
    }
}
