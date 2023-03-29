package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapps";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);

        String absolutePath = new File(webappDirLocation).getAbsolutePath();
        log.info("webapps: {}", absolutePath);
        tomcat.addWebapp("", absolutePath);

        tomcat.start();
        tomcat.getServer().await();
    }
}
