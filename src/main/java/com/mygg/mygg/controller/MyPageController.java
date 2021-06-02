package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MyPageDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MyPageController {

    private final MemberService memberService;

    @Autowired
    public MyPageController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/info")
    public String myPage(HttpSession httpSession) throws Exception {

        Integer id = (int) httpSession.getAttribute("id");
        Map <String, String> memberActivity = memberService.activity(id);

        System.out.println(memberActivity + "--------------------------");
        if(memberActivity.get("id") != null) {
            httpSession.setAttribute("level", memberActivity.get("level"));
            httpSession.setAttribute("wish", memberActivity.get("wish"));
            httpSession.setAttribute("batch", memberActivity.get("batch"));
            httpSession.setAttribute("mileage", memberActivity.get("mileage"));
            return "/member/myinfo";
        } else {
            return "redirect:/member/login";
        }
    }

    // introduction page
    @GetMapping("/introduction")
    public String introductionGET() {
        return "/member/introduction";
    }

    // introduction 입력 처리
    @PostMapping("/introduction")
    public String introductionPOST(MyPageDTO myPageDTO) {
        memberService.introduction(myPageDTO);
        return "/member/introduction";
    }

}