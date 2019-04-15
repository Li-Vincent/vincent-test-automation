package com.qa.lib;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class ReporterLogger {

    private Logger LOGGER;
    static final String FQCN = ReporterLogger.class.getName();

    public ReporterLogger(Class<?> clazz) {
        PropertyConfigurator.configure("log4j.properties");
        LOGGER = Logger.getLogger(clazz);
    }

    public void info(String message) {
        // 使用slf4j打印到控制台或者文件
        LOGGER.log(FQCN, Level.INFO, message, null);
        message = getLogTag() + message;
        // 记录到Reporter
        Reporter.log(message);
    }

    // 根据堆栈信息，拿到调用类的名称、方法名、行号
    public String getLogTag() {
        String logTag = "";
        Long timeStamp = System.currentTimeMillis();
        String dateString = timestampToDate(timeStamp);
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (int i = 0; i < stack.length; i++) {
            StackTraceElement s = stack[i];
            if (s.getClassName().equals(LOGGER.getName())) {
                logTag = "[" + dateString + "]" + "[" + classNameDeal(s.getClassName()) + ":" + s.getMethodName() + ":"
                        + s.getLineNumber() + "]";
            }
        }
        return logTag;
    }

    // 时间戳转date字符串
    public static String timestampToDate(Long timestamp) {
        if (timestamp.toString().length() < 13) {
            timestamp = Long.valueOf(timestamp.toString().substring(0, 10) + "000");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date(timestamp);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    // 去掉包名，只保留类名
    private String classNameDeal(String allName) {
        String[] className = allName.split("\\.");
        return className[className.length - 1];
    }
}
