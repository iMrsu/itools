package com.miaoc.itools.base.controller;


import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.Description;
import com.miaoc.itools.base.entity.Dishes;
import com.miaoc.itools.base.entity.ResBody;
import com.miaoc.itools.base.service.IDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/base")
public class DescriptionController {

    @Autowired
    private IDescriptionService iDescriptionService;

    @RequestMapping(value = "/getdescription")
    @ResponseBody
    public ResBody getdescription(@RequestBody JSONObject req) throws Exception {
        ResBody res = new ResBody();//返回值
        List<Description> dishes = iDescriptionService.getDescription();
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(dishes);
        return res;
    }


    @RequestMapping(value = "/setDescription")
    @ResponseBody
    public ResBody setDescription(@RequestBody Description description) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer result = iDescriptionService.setDescription(description);
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(result);
        return res;
    }

    @RequestMapping(value = "/descriptionList")
    @ResponseBody
    public ResBody descriptionList(@RequestBody Description description) throws Exception {
        ResBody res = new ResBody();//返回值
        List<Description> dishes = iDescriptionService.getDescription();
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(dishes);
        return res;
    }

    @RequestMapping(value = "/delDescription")
    @ResponseBody
    public ResBody delDescription(@RequestBody Description description) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer result = iDescriptionService.delDescription(description);
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(result);
        return res;
    }

    @RequestMapping(value = "/editDescription")
    @ResponseBody
    public ResBody editDescription(@RequestBody Description description) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer result = iDescriptionService.editDescription(description);
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(result);
        return res;
    }


}

