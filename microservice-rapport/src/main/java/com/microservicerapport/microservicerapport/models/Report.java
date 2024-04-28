package com.microservicerapport.microservicerapport.models;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;

public class Report {
    private Long PatId;
    private String risk;

    public Report(){}
    public Report(Long PatId, String risk){
        this.PatId = PatId;
        this.risk = risk;
    }
    public static Report fromDict(String jsonString) {
        return JsonIterator.deserialize(jsonString, Report.class);
    }

    public static String toDict(Report report) {
        return JsonStream.serialize(report);
    }

}
