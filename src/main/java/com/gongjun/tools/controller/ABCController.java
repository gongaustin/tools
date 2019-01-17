package com.gongjun.tools.controller;

import com.gongjun.tools.core.annotation.MyLog;
import com.gongjun.tools.model.Test;
import com.gongjun.tools.service.ITestService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Controller和@RestController的区别？
 *
 * 官方文档：
 * @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
 * 意思是：
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 *
 * 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 例如：本来应该到success.jsp页面的，则其显示success.
 * 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 **/
/*
 * 定义控制层采用@RestController/@Controller
 */
@RestController
@RequestMapping("")
@Api(value = "/", description = "测试接口")
public class ABCController {
    @Resource
    private ITestService service;
    @MyLog("查询个数")
    @GetMapping("")
    public String ABC(String a,String b) {
        List<Test> tests = this.service.selectList(null);
        System.out.println(null == tests ? null : tests.size());
        return "hello";
    }
    /**
     * @param [aa, bb]
     * @description 方法注解采用"/m"然后tab键即可
     * @author GongJun
     * @time 2019/1/17 11:03
     * @return java.lang.String
     **/
    public String ss(String aa, String bb) {
        return aa + bb;
    }
}
