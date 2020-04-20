package com.miaoc.itools.base.service.impl;

import com.miaoc.itools.base.entity.Description;
import com.miaoc.itools.base.entity.Dishes;
import com.miaoc.itools.base.mapper.DescriptionMapper;
import com.miaoc.itools.base.mapper.DishesMapper;
import com.miaoc.itools.base.service.IDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoc.itools.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
@Service("iDescriptionService")
public class DescriptionServiceImpl extends ServiceImpl<DescriptionMapper, Description> implements IDescriptionService {

    @Resource
    private DescriptionMapper descriptionMapper;
    @Resource
    private DishesMapper dishesMapper;
    @Autowired
    private BaseUtils baseUtils;

    @Override
    public List<Description> getDescription() {
        List<Description> list = new ArrayList<>();
        list = descriptionMapper.getdescription();
        return list;
    }

    @Override
    public Integer setDescription(Description description) {
        Description des = descriptionMapper.getMaxDesci();
        description.setDescriptionId(String.valueOf((Integer.parseInt(des.getDescriptionId())+1)));
        Integer res = descriptionMapper.insert(description);
        return res;
    }

    @Override
    public Integer delDescription(Description description) {
        Integer result = descriptionMapper.deleteById(description.getDescriptionId());
        return result;
    }

    @Override
    public Integer editDescription(Description description) {
        Integer result = descriptionMapper.updateById(description);
        return result;
    }
}
