package com.java.javaee.ee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/temp")
public class TempServlet extends HttpServlet {

    int i = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s + " = " + req.getHeader(s));
        }
        System.out.println(req.getAuthType());
        System.out.println(req.getContentLength());
        System.out.println(req.getContentType());
        System.out.println(req.getMethod());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());
        System.out.println(req.getProtocol());
        synchronized (this) {
            String one = req.getParameter("one");
            one = one == null ? "" : one.replaceAll("<", "&lt;").replaceAll(">","&gt;");
//            String two = req.getParameter("two");
            System.out.println(one);
            String[] ones = req.getParameterValues("one");
            for (String s : ones) {
                System.out.println(s);
            }
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                System.out.println(parameterNames.nextElement());
                String elementName = parameterNames.nextElement();
                System.out.println(elementName + " = " + req.getParameter(elementName));
            }
            Map<String, String[]> parameterMap = req.getParameterMap();

            System.out.println(req.getRequestURL());
            System.out.println(req.getRequestURI());
            System.out.println(req.getServletPath());
            System.out.println(req.getRemoteHost());
            System.out.println(req.getLocalPort());
            System.out.println(req.getQueryString());

            for (int j = 0; j < 1_000_000; j++) {
                i++;
           /* int k = i;
            k = k + 1;
            i = k;*/
                System.out.println(i);
            }

            super.doGet(req, resp);
            System.out.println(Thread.currentThread().getName());


            resp.getWriter().write("<html>" +
                    "<head>" +
                    "</head>" +
                    "<body>" +
                    "one = " + one +
//                    "two = " + two +
                    "<form action = 'temp' method = 'post>" +
                    "<textarea name = 'one'/></textarea>" +
                    "<input type = 'text' name = 'one>" +
                    "<input type = 'text' name = 'two'>" +
                    "<input type = 'submit' name = 'submit'>" +
                    "</form>" +
                    "</body>" +
                    "</html>");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/temp").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}