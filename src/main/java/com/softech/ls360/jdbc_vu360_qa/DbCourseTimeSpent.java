package com.softech.ls360.jdbc_vu360_qa;

import com.softech.ls360.constant.CONSTANT;
import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by syed.musab on 11/10/2016.
 */
public class DbCourseTimeSpent {

    private static final Logger logger = LoggerFactory.getLogger(DbUdpCourseStatus.class);
    private static final String UDP_COURSE_COUNT_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpsqlqueries = new getPropertyValueFromPropertiesFile();

    String URL = udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.url", UDP_COURSE_COUNT_PROPERTIES_FILE) +
            udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.lms", UDP_COURSE_COUNT_PROPERTIES_FILE) +
            udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.username", UDP_COURSE_COUNT_PROPERTIES_FILE) +
            udpsqlqueries.getPropertyValueFromPropertiesFile("connection.com.lms.database.database.password", UDP_COURSE_COUNT_PROPERTIES_FILE);

    Connection conn = null;
    Statement stmt = null;

    public int getCourseTimeSpentInfo() {

        ResultSet rsTimeSpent = null;
        int resultTimeSpent = 0;

        try {
            Class.forName(udpsqlqueries.getPropertyValueFromPropertiesFile("learnerCount.information.classname", UDP_COURSE_COUNT_PROPERTIES_FILE));
            conn = DriverManager.getConnection(URL);

            String learnerCourseTimeSpentInfo = CONSTANT.COURSE_TIME_SPENT;
            logger.info("-QUERY:" + learnerCourseTimeSpentInfo);

            stmt = conn.createStatement();
            rsTimeSpent = stmt.executeQuery(learnerCourseTimeSpentInfo);

            if (rsTimeSpent.next()) {
                resultTimeSpent = rsTimeSpent.getInt(1);
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

        logger.info("-Result:->" + resultTimeSpent);
        return resultTimeSpent;

    }

}
