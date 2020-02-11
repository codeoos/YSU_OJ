package com.ysu.acm;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ini_test {
    @PostMapping("/q")
    public String myt(){
        String str="QAQ";
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
