package com.gongjun.tools.controller;

import com.gongjun.tools.model.Test;
import com.gongjun.tools.service.ITestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("")
public class ABCController {
    @Resource
    private ITestService service;
    @GetMapping("")
    public String ABC(){
        List<Test> tests = this.service.selectList(null);
        System.out.println(null == tests?null:tests.size());
        return "hello";
    }
}
