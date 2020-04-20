package com.miaoc.itools.base.service;

import com.miaoc.itools.base.entity.Description;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoc.itools.base.entity.Dishes;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
public interface IDescriptionService extends IService<Description> {

    List<Description> getDescription();

    Integer setDescription(Description description);

    Integer delDescription(Description description);

    Integer editDescription(Description description);

}
