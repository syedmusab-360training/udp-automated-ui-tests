package com.softech.ls360.constant;

import com.softech.ls360.jdbc_vu360_qa.DbConnection;
import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/20/2016.
 */
public class CONSTANT {

    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);
    private static final String UDP_COURSE_COUNT_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private static getPropertyValueFromPropertiesFile udpsqlqueries = new getPropertyValueFromPropertiesFile();


    // !!------Queries for Learner Course Count - Completed Courses---!!

    public static final String LEARNERCOUNT_COMPLETED =

            "select COUNT(LE.ID) from LEARNERENROLLMENT LE\n" +
                    "INNER JOIN LEARNER L ON LE.LEARNER_ID = L.ID\n" +
                    "INNER JOIN VU360USER vu ON vu.ID = L.VU360USER_ID\n" +
                    "INNER JOIN LEARNERCOURSESTATISTICS LCS ON LCS.LEARNERENROLLMENT_ID = LE.ID\n" +
                    "WHERE le.enrollmentstatus =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.enrollmentstatus",
                    UDP_COURSE_COUNT_PROPERTIES_FILE) + "and vu.USERNAME ="
                    + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.vuUsername",
                    UDP_COURSE_COUNT_PROPERTIES_FILE) +
                    "AND LCS.STATUS =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.status.completed",
                    UDP_COURSE_COUNT_PROPERTIES_FILE);

    // !!------Queries for Learner Course Count - Subscription Courses---!!

    public static final String LEARNERCOUNT_SUBSCRIPTION =
            "select COUNT(LE.ID) from LEARNERENROLLMENT LE\n" +
                    "INNER JOIN LEARNER L ON LE.LEARNER_ID = L.ID\n" +
                    "INNER JOIN VU360USER vu ON vu.ID = L.VU360USER_ID\n" +
                    "INNER JOIN LEARNERCOURSESTATISTICS LCS ON LCS.LEARNERENROLLMENT_ID = LE.ID\n" +
                    "WHERE le.enrollmentstatus =" +
                    udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.enrollmentstatus",
                            UDP_COURSE_COUNT_PROPERTIES_FILE)
                    + "and vu.USERNAME =" +
                    udpsqlqueries.getPropertyValueFromPropertiesFile
                            ("learnerCount.information.vuUsername",
                                    UDP_COURSE_COUNT_PROPERTIES_FILE) +
                    "AND LCS.STATUS ="
                    + udpsqlqueries.getPropertyValueFromPropertiesFile
                    ("learnerCount.status.subscription", UDP_COURSE_COUNT_PROPERTIES_FILE);


    // !!------Queries for Learner Course Count - All Courses Count---!!

    public static final String LEARNERCOUNT_ALL =
            "select COUNT(LE.ID) from LEARNERENROLLMENT LE\n" +
                    "INNER JOIN LEARNER L ON LE.LEARNER_ID = L.ID\n" +
                    "INNER JOIN VU360USER vu ON vu.ID = L.VU360USER_ID\n" +
                    "INNER JOIN LEARNERCOURSESTATISTICS LCS ON LCS.LEARNERENROLLMENT_ID = LE.ID\n" +
                    "WHERE le.enrollmentstatus =" +
                    udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.enrollmentstatus",
                            UDP_COURSE_COUNT_PROPERTIES_FILE)
                    + "and vu.USERNAME =" +
                    udpsqlqueries.getPropertyValueFromPropertiesFile
                            ("learnerCount.information.vuUsername",
                                    UDP_COURSE_COUNT_PROPERTIES_FILE);


    public static final String NEW_COURSE_STATUS =
            "select LCS.*, CR.NAME, CR.GUID, CR.COURSETYPE, LE.* from LEARNERENROLLMENT LE\n" +
                    "INNER JOIN LEARNER L ON LE.LEARNER_ID = L.ID\n" +
                    "INNER JOIN VU360USER vu ON vu.ID = L.VU360USER_ID\n" +
                    "INNER JOIN COURSE CR ON CR.ID = LE.COURSE_ID\n" +
                    "INNER JOIN LEARNERCOURSESTATISTICS LCS ON LCS.LEARNERENROLLMENT_ID = LE.ID\n" +
                    "WHERE le.enrollmentstatus =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.enrollmentstatus", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                    "and vu.USERNAME =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.vuUsername", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                    "and status =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCourse.information.status.new", UDP_COURSE_COUNT_PROPERTIES_FILE);


    public static final String STARTED_COURSE_STATUS =
            "select LCS.*, CR.NAME, CR.GUID, CR.COURSETYPE, LE.* from LEARNERENROLLMENT LE\n" +
                    "INNER JOIN LEARNER L ON LE.LEARNER_ID = L.ID\n" +
                    "INNER JOIN VU360USER vu ON vu.ID = L.VU360USER_ID\n" +
                    "INNER JOIN COURSE CR ON CR.ID = LE.COURSE_ID\n" +
                    "INNER JOIN LEARNERCOURSESTATISTICS LCS ON LCS.LEARNERENROLLMENT_ID = LE.ID\n" +
                    "WHERE le.enrollmentstatus =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.enrollmentstatus", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                    "and vu.USERNAME =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.vuUsername", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                    "and status =" + udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCourse.information.status.started", UDP_COURSE_COUNT_PROPERTIES_FILE);
}
