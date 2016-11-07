package com.softech.ls360.jdbc_vu360_qa;

import com.softech.ls360.constant.CONSTANT;
import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by syed.musab on 10/28/2016.
 */
public class DbUdpCourseStatus {

    private static final Logger logger = LoggerFactory.getLogger(DbUdpCourseStatus.class);
    private static final String UDP_COURSE_COUNT_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpsqlqueries = new getPropertyValueFromPropertiesFile();

    String URL = udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.url", UDP_COURSE_COUNT_PROPERTIES_FILE) +
            udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.lms", UDP_COURSE_COUNT_PROPERTIES_FILE) +
            udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.username", UDP_COURSE_COUNT_PROPERTIES_FILE) +
            udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.password", UDP_COURSE_COUNT_PROPERTIES_FILE);

    Connection conn = null;
    Statement stmt = null;

    public String getLearnerNewStatusCourseInfo() {

        ResultSet rsNew = null;
        String resultNew = null;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerNewCourse = CONSTANT.NEW_COURSE_STATUS;
            logger.info("-QUERY:" + learnerNewCourse);

            stmt = conn.createStatement();
            rsNew = stmt.executeQuery(learnerNewCourse);

            if (rsNew.next()) {
                resultNew = rsNew.getString("NAME");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("New -Result:->" + resultNew);
        return resultNew;

    }


    public String getLearnerStartedStatusCourseInfo() {

        ResultSet rsNew = null;
        String resultNew = null;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerStartedCourse = CONSTANT.STARTED_COURSE_STATUS;
            logger.info("-QUERY:" + learnerStartedCourse);

            stmt = conn.createStatement();
            rsNew = stmt.executeQuery(learnerStartedCourse);

            while (rsNew.next()) {
                resultNew = rsNew.getString(32);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("Started -Result:->" + resultNew);
        return resultNew;

    }


    public String getLearnerCompletedStatusCourseInfo() {

        ResultSet rsNew = null;
        String resultNew = null;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerCompletedCourse = CONSTANT.COMPLETED_COURSE_STATUS;
            logger.info("-QUERY:" + learnerCompletedCourse);

            stmt = conn.createStatement();
            rsNew = stmt.executeQuery(learnerCompletedCourse);

            while (rsNew.next()) {
                resultNew = rsNew.getString("NAME");
                logger.info("Completed Course -Result:->" + resultNew);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("Completed Course -Result:->" + resultNew);
        return resultNew;

    }

}
