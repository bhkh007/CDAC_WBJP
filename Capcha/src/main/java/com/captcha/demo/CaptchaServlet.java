package com.captcha.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CaptchaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 150;
        int height = 50;
        List<Character> arrayList = new ArrayList<>();
        String capcode = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
        
        for (int i = 0; i < capcode.length(); i++) {
            arrayList.add(capcode.charAt(i));
        }
        Collections.shuffle(arrayList);
        
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            s2.append(arrayList.get(i));
        }
        
        String captcha = s2.toString();
        request.getSession().setAttribute("captcha", captcha);
        
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        
        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        
        GradientPaint gp = new GradientPaint(0, 0, Color.red, 0, height / 2, Color.black, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        
        g2d.setColor(new Color(255, 153, 0));
        Random r = new Random();
        
        int x = 0;
        int y = 0;
        for (int i = 0; i < captcha.length(); i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(captcha.toCharArray(), i, 1, x, y);
        }
        
        g2d.dispose();
        response.setContentType("image/png");
        
        try (OutputStream os = response.getOutputStream()) {
            ImageIO.write(bufferedImage, "png", os);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
