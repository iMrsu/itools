package com.miaoc.itools.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.*;
import com.miaoc.itools.base.mapper.ConsumerRecordMapper;
import com.miaoc.itools.base.mapper.DescriptionMapper;
import com.miaoc.itools.base.mapper.DishesMapper;
import com.miaoc.itools.base.service.IDishesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoc.itools.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
@Service("iDishesService")
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements IDishesService {

    @Resource
    private DescriptionMapper descriptionMapper;

    @Resource
    private ConsumerRecordMapper consumerRecordMapper;

    @Resource
    private com.miaoc.itools.base.mapper.ConsumerHisMapper ConsumerHisMapper;

    @Autowired
    private BaseUtils baseUtils;

    @Resource
    private DishesMapper dishesMapper;

    @Override
    public List<Description> getdishes() {
        List<Description> dishes = descriptionMapper.getdishes();
        return dishes;
    }

    @Override
    public Integer setDescription(Dishes dishes) {
        dishes.setDishesId(baseUtils.getUUID());
        Integer res= dishesMapper.insert(dishes);
        return res;
    }

    @Override
    public List<DishesOutput> dishesList() {
        List<DishesOutput> list = new ArrayList<DishesOutput>();
        list = dishesMapper.dishesList();
        return list;
    }

    @Override
    public Integer delDeshes(Dishes dishes) {
        Integer res= dishesMapper.deleteById(dishes);
        return res;
    }

    @Override
    public Integer editDeshes(Dishes dishes) {
        Integer res= dishesMapper.updateById(dishes);
        return res;
    }

    @Override
    public Integer makeOrder(JSONObject req) {

        // 新增consume_record
        ConsumerRecord consumerRecord=new ConsumerRecord();
        consumerRecord.setRecordId(baseUtils.getUUID());
        consumerRecord.setTotalPrice(new BigDecimal(req.get("totalPrice").toString()));
        consumerRecord.setTableId(req.get("tableId").toString());
        consumerRecord.setConsumerData(baseUtils.getDatatime());
        Boolean re = consumerRecordMapper.addConsumeRecord(consumerRecord);

        // 新增consume_his
        List selectFoods = (List) req.get("selectFoods");
        List<ConsumerHis> listConsumerHis = new ArrayList<>();
        ConsumerHis consumerHis=null;
        for(int i=0;i<selectFoods.size();i++){
            consumerHis = new ConsumerHis();
            consumerHis.setId(baseUtils.getUUID());
            consumerHis.setDishesId(((Map)selectFoods.get(i)).get("dishesId").toString());
            consumerHis.setRecordId(consumerRecord.getRecordId());
            listConsumerHis.add(consumerHis);
        }
        Integer his = ConsumerHisMapper.createBatchConsumerHisList(listConsumerHis);
        if (re && his > 0){
            return 1;
        }else {
            return  0;
        }
    }
}
