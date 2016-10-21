package com.softech.ls360.jdbc_vu360_qa;

import com.softech.ls360.CONSTANT;
import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by syed.musab on 10/20/2016.
 */
public class DbConnection {

        private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);
        private static final String UDP_COURSE_COUNT_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
        private getPropertyValueFromPropertiesFile udpsqlqueries = new getPropertyValueFromPropertiesFile();

        String URL = udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.url", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.lms", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.username", UDP_COURSE_COUNT_PROPERTIES_FILE) +
                udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.password", UDP_COURSE_COUNT_PROPERTIES_FILE);

        Connection conn = null;
        Statement stmt = null;

    public int getLearnerCountCompletedInfo() {

        ResultSet rsCompleted = null;
        int resultCompleted = 0;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerCompleted = CONSTANT.LEARNERCOUNT_COMPLETED;
            logger.info("-QUERY:" + learnerCompleted);

            stmt = conn.createStatement();
            rsCompleted = stmt.executeQuery(learnerCompleted);

            if (rsCompleted.next()) {
                resultCompleted = rsCompleted.getInt(1);
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

        logger.info("-Result:->" + resultCompleted);
        return resultCompleted;

    }

    public int getLearnerCountSubscriptionInfo() {

        ResultSet rsSubscription = null;
        int resultSubscription = 0;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerSubscription = CONSTANT.LEARNERCOUNT_SUBSCRIPTION;
            logger.info("-QUERY:" + learnerSubscription);

            stmt = conn.createStatement();
            rsSubscription = stmt.executeQuery(learnerSubscription);

            if (rsSubscription.next()){
                resultSubscription = rsSubscription.getInt(1);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("-Result:->"+ resultSubscription);
        return resultSubscription;

    }

    public int getLearnerCountAllCoursesInfo() {

        ResultSet rsCoursesAll = null;
        int resultCountAll = 0;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerCountAllInfo = CONSTANT.LEARNERCOUNT_ALL;
            logger.info("-QUERY:" + learnerCountAllInfo);

            stmt = conn.createStatement();
            rsCoursesAll = stmt.executeQuery(learnerCountAllInfo);

            if (rsCoursesAll.next()){
                resultCountAll = rsCoursesAll.getInt(1);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("-Result:->"+ resultCountAll);
        return resultCountAll;

    }

    }


