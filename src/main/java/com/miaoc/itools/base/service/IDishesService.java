package com.miaoc.itools.base.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.Description;
import com.miaoc.itools.base.entity.Dishes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoc.itools.base.entity.DishesOutput;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
public interface IDishesService extends IService<Dishes> {

    List<Description> getdishes();

    Integer makeOrder(JSONObject req);

    Integer setDescription(Dishes dishes);

    List<DishesOutput> dishesList();

    Integer delDeshes(Dishes dishes);

    Integer editDeshes(Dishes dishes);

}
