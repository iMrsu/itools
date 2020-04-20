package com.miaoc.itools.base.controller;


import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.Description;
import com.miaoc.itools.base.entity.Dishes;
import com.miaoc.itools.base.entity.DishesOutput;
import com.miaoc.itools.base.service.IDescriptionService;
import com.miaoc.itools.base.service.IDishesService;
import com.miaoc.itools.base.entity.ResBody;
import com.miaoc.itools.utils.system.ErrorMessage;
import com.miaoc.itools.utils.system.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
public class DishesController {

    @Autowired
    private IDishesService iDishesService;

    @Autowired
    private IDescriptionService iDescriptionService;

    @RequestMapping("")
    public List<DishesOutput> getUserList(){
        List<DishesOutput> userVoList = new ArrayList<>();
        DishesOutput dishes = new DishesOutput();
        dishes.setDishesId("1");
        dishes.setInfo("你好");
        userVoList.add(dishes);
        dishes = new DishesOutput();
        dishes.setDishesId("2");
        dishes.setInfo("我好");
        userVoList.add(dishes);
        try {
            System.out.println(userVoList.get(3));
        }catch (Exception e){
            throw new ServiceException(405,ErrorMessage.LOGIC_EXCEPTION);
        }
        return userVoList;
    }

    @RequestMapping(value = "/getdishes")
    @ResponseBody
    public  List<Description> getdishes(@RequestBody JSONObject req) throws Exception {
        List<Description> dishes = iDishesService.getdishes();
        return dishes;
    }

    @RequestMapping(value = "/makeOrder")
    @ResponseBody
    public ResBody makeOrder(@RequestBody JSONObject req) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer result = iDishesService.makeOrder(req);
        res.setStatus(result);
        res.setMsg("成功");
//        res.setResData();
        return res;
    }

    @RequestMapping(value = "/setDishes")
    @ResponseBody
    public ResBody setDishes(@RequestBody Dishes dishes) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer dishe = iDishesService.setDescription(dishes);
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(dishe);
        return res;
    }

    @RequestMapping(value = "/dishesList")
    @ResponseBody
    public ResBody dishesList(@RequestBody JSONObject req) throws Exception {
        ResBody res = new ResBody();//返回值
        List<DishesOutput> dishes = iDishesService.dishesList();
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(dishes);
        return res;
    }

    @RequestMapping(value = "/delDeshes")
    @ResponseBody
    public ResBody delDeshes(@RequestBody Dishes Dishes) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer result = iDishesService.delDeshes(Dishes);
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(result);
        return res;
    }

    @RequestMapping(value = "/editDeshes")
    @ResponseBody
    public ResBody editDeshes(@RequestBody Dishes Dishes) throws Exception {
        ResBody res = new ResBody();//返回值
        Integer result = iDishesService.editDeshes(Dishes);
        res.setStatus(1);
        res.setMsg("成功");
        res.setResData(result);
        return res;
    }
}

