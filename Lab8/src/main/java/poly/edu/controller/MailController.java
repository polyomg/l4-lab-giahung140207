package poly.edu.controller;

import ch.qos.logback.core.model.Model;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import poly.edu.service.MailService;

@Controller
public class MailController {
    @Autowired
    MailService mailService;
    @ResponseBody
    @RequestMapping("/mail/send")
    public String send(Model model) {
        mailService.push("receiver@gmail.com", "Subject", "Body");
        return "Mail của bạn đã được xếp vào hàng đợi";
    }
}
