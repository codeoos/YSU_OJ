package com.ysu.acm.user;

import com.ysu.acm.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Register {
    @Autowired
    private user_connector_repository connector_repository;
    @PostMapping("/login")
    public Message login(@RequestParam("usr_name") String usr_name,
                         @RequestParam("pwd") String pwd,
                         @RequestParam("e_mail") String e_mail,
                         @RequestParam("tel") String tel){
        String md5= DigestUtils.md5DigestAsHex(pwd.getBytes());
        user usr=connector_repository.find_by_usrname(usr_name);
        Message res = new Message();
        res.setSuccess(false);
        //check if the usr_name is existed
        if(usr!=null){
            System.out.println("This user is existed!");
            res.setSuccess(false);
            res.setMsg("This user is existed!");
        }else{
            //Check if the tel is right
            String regex="^1[3|4|5|7|8][0-9]\\d{4,8}$";
            if(tel.length()!=11) {
                res.setMsg("The tel is incorrect!");
                return res;
            }else{
                Pattern p=Pattern.compile(regex);
                Matcher m=p.matcher(tel);
                if(!m.matches()){
                    res.setMsg("The tel is incorrect!");
                    return res;
                }
            }
            //Check if the e-mail is rignt
            regex="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            {
                Pattern p=Pattern.compile(regex);
                Matcher m=p.matcher(e_mail);
                if(!m.matches()){
                    res.setMsg("The e-mail is incorrect!");
                    return  res;
                }
            }
            
            res.setMsg("OK");
            res.setSuccess(true);
        }
        return res;
    }
}
