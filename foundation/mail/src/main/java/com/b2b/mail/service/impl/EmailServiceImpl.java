/*
 * EmailServiceImpl.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.mail.service.impl;

import com.b2b.mail.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * EmailServiceImpl.java
 *
 * @author Nguyen
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendOTP(String email, String otp) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        helper.setFrom("nguyenlee11030403@gmail.com");
        helper.setTo(email);
        helper.setSubject("");

        String body =
                "<!doctype html>\n" +
                        "<html lang=\"vi\">\n" +
                        "  <head>\n" +
                        "    <meta charset=\"utf-8\" />\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                        "    <title>Xác nhận OTP</title>\n" +
                        "  </head>\n" +
                        "  <body style=\"margin:0; padding:0; background:#f5f7fb; font-family:Arial, Helvetica, sans-serif;\">\n" +
                        "    <table role=\"presentation\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"background:#f5f7fb; padding:24px 12px;\">\n" +
                        "      <tr>\n" +
                        "        <td align=\"center\">\n" +
                        "          <table role=\"presentation\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" style=\"max-width:600px; background:#ffffff; border-radius:12px; overflow:hidden;\">\n" +
                        "            <tr>\n" +
                        "              <td style=\"padding:24px 24px 8px 24px;\">\n" +
                        "                <h2 style=\"margin:0; font-size:20px; color:#111827;\">Xác nhận kích hoạt tài khoản</h2>\n" +
                        "              </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td style=\"padding:12px 24px 8px 24px; color:#374151; font-size:15px; line-height:1.6;\">\n" +
                        "                <p style=\"margin:0 0 12px 0;\">\n" +
                        "                  Cam on ban da dang ky dich vu cua chung toi.<br/>\n" +
                        "                  Hay nhap ma otp de kich hoat tai khoan.\n" +
                        "                </p>\n" +
                        "                <p style=\"margin:0 0 10px 0; color:#6b7280; font-size:14px;\">Mã OTP:</p>\n" +
                        "                <div style=\"display:inline-block; background:#111827; color:#ffffff; padding:14px 20px; border-radius:10px; font-size:28px; font-weight:700; letter-spacing:2px; line-height:1;\">\n" +
                        otp +
                        "                </div>\n" +
                        "                <p style=\"margin:14px 0 0 0; color:#9ca3af; font-size:13px;\">Lưu ý: Mã OTP có hiệu lực trong thời gian ngắn.</p>\n" +
                        "              </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td style=\"padding:18px 24px 24px 24px; color:#6b7280; font-size:12px; line-height:1.5; border-top:1px solid #eef2f7;\">\n" +
                        "                <p style=\"margin:0;\">Nếu bạn không thực hiện yêu cầu này, vui lòng bỏ qua email hoặc liên hệ hỗ trợ.</p>\n" +
                        "              </td>\n" +
                        "            </tr>\n" +
                        "          </table>\n" +
                        "        </td>\n" +
                        "      </tr>\n" +
                        "    </table>\n" +
                        "  </body>\n" +
                        "</html>";

        helper.setText(body, true);

        mailSender.send(message);
    }
}
