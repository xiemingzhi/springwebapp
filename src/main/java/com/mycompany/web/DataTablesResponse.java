package com.mycompany.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DataTablesResponse <T> implements Serializable {

    @JsonProperty(value = "iTotalRecords")
    public int totalRecords;

    @JsonProperty(value = "iTotalDisplayRecords")
    public int totalDisplayRecords;

    @JsonProperty(value = "sEcho")
    public String echo;

    @JsonProperty(value = "sColumns")
    public String columns;

    @JsonProperty(value = "aaData")
    public List<T> data = new ArrayList<T>();

    public DataTablesResponse() {
    }
}