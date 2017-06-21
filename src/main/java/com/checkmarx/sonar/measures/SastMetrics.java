package com.checkmarx.sonar.measures;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by: Zoharby.
 * Date: 23/05/2017.
 */
public class SastMetrics implements Metrics {

    public static String CX_SAST_DOMAIN = "Checkmarx SAST Security";

    public static String SAST_BASE_KEY = "cx.sast.result";

    public static final Metric<Integer> SAST_HIGH_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+".high", "High Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_MEDIUM_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+".medium", "Medium Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_LOW_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +".low", "Low Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();



    public static final Metric<Integer> SAST_TOTAL_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +".total", "Total Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_NEW_HIGH_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+"new.high", "New High Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_NEW_MEDIUM_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY+"new.medium", "New Medium Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_NEW_LOW_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +"new.low", "New Low Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<Integer> SAST_TOTAL_NEW_VULNERABILITIES = new Metric.Builder(SAST_BASE_KEY +".new.total", "Total New Vulnerabilities", Metric.ValueType.INT)
            .setDescription("Non commenting lines of code")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CX_SAST_DOMAIN)
            .create();

    public static final Metric<String> SAST_SCAN_DETAILS = new Metric.Builder(SAST_BASE_KEY +".details", "Checkmarx sast scan details", Metric.ValueType.STRING)
            .setDescription("Additional scan details")
            .setQualitative(true)
           // .setHidden(true)
            .setDomain(CX_SAST_DOMAIN)
            .create();


    @Override
    public List<Metric> getMetrics() {
        return asList(SAST_HIGH_VULNERABILITIES, SAST_MEDIUM_VULNERABILITIES, SAST_LOW_VULNERABILITIES, SAST_TOTAL_VULNERABILITIES,
                SAST_NEW_HIGH_VULNERABILITIES, SAST_NEW_MEDIUM_VULNERABILITIES, SAST_NEW_LOW_VULNERABILITIES, SAST_TOTAL_NEW_VULNERABILITIES, SAST_SCAN_DETAILS);
    }
}
