package com.java.javaee.ee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebServlet("/temp")
public class TempServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(cookie.getMaxAge());
        }
        Cookie cookie = new Cookie("testCooke","abc");
        cookie.getComment();
        cookie.setPath("/temp.html");
        cookie.setDomain("second.my.localhost.com");
        cookie.setSecure(true);
        resp.addCookie(cookie);
        cookie.setMaxAge(5);
    }
}
