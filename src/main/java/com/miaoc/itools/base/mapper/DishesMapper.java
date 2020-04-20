package com.miaoc.itools.base.mapper;

import com.miaoc.itools.base.entity.Description;
import com.miaoc.itools.base.entity.Dishes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoc.itools.base.entity.DishesOutput;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2019-07-14
 */
public interface DishesMapper extends BaseMapper<Dishes> {


    /** 
     * @Description:
     * @Param:  
     * @return:  
     * @Author: Mr.cc 
     * @Date: 2019/7/14 
     */
    List<Dishes> dishes();

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int createBatchDishesList(List<Dishes> list);

    @Select("SELECT dishes_id as dishesId,CONCAT(e.description_id,'-',e.`name`) AS descriptionId,d.name,price,sell_count as sellCount,description,info,d.remarks FROM Dishes d LEFT JOIN description e ON d.description_id=e.description_id ")
    List<DishesOutput> dishesList();

}
