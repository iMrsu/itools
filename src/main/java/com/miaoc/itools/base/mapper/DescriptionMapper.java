package com.miaoc.itools.base.mapper;

import com.miaoc.itools.base.entity.Description;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoc.itools.base.entity.Dishes;
import org.apache.ibatis.annotations.Mapper;
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
public interface DescriptionMapper extends BaseMapper<Description> {

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: Mr.cc
     * @Date: 2019/7/14
     */
    List<Description> getdishes();

    @Select("SELECT * FROM description ")
    List<Description> getdescription();

    @Select(" select * from description order by description_id + 0 desc limit 1 ")
    Description getMaxDesci();



}
