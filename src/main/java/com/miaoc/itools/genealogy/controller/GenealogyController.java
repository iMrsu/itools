package com.miaoc.itools.genealogy.controller;


import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.ResBody;
import com.miaoc.itools.base.service.IDishesService;
import com.miaoc.itools.genealogy.entity.GenealGetInput;
import com.miaoc.itools.genealogy.entity.GenealGetout;
import com.miaoc.itools.genealogy.service.IGenealogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/genealogy")
public class GenealogyController {

    @Resource
    private IGenealogyService iGenealogyService;

    @RequestMapping(value = "/getFenealList")
    @ResponseBody
    public Object getFenealList(@RequestBody JSONObject req) throws Exception {
        List<GenealGetout> output =new ArrayList<>();
        output = iGenealogyService.getFenealList(req);
        return output;
    }
    @RequestMapping(value = "/getFenealLists")
    @ResponseBody
    public Object getFenealLists(@RequestBody JSONObject req) throws Exception {
        List<Map<String,Object>> output =new ArrayList<>();
        output = iGenealogyService.getFenealLists(req);
        return output;
    }

    @RequestMapping(value = "/createData")
    @ResponseBody
    public Object createData(@RequestBody GenealGetInput input) throws Exception {
        GenealGetout output = iGenealogyService.createData(input);
        return output;
    }
    @RequestMapping(value = "/updateData")
    @ResponseBody
    public Object updateData(@RequestBody GenealGetInput input) throws Exception {
        GenealGetout output = iGenealogyService.updateData(input);
        return output;
    }

    @RequestMapping(value = "/deleteData")
    @ResponseBody
    public Object deleteData(@RequestBody GenealGetInput input) throws Exception {
        GenealGetout output = iGenealogyService.deleteData(input);
        return output;
    }
}



