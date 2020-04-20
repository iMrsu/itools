package com.miaoc.itools.genealogy.mapper;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.base.entity.ConsumerRecord;
import com.miaoc.itools.genealogy.entity.GenealGetout;
import com.miaoc.itools.genealogy.entity.Genealogy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
public interface GenealogyMapper extends BaseMapper<Genealogy> {

    @Select("SELECT a.org_id,a.pid,a.user_id,b.username,b.epithet,b.elder_order,b.lineage,b.wife_lastname,b.remark,b.child_order FROM geneal a LEFT JOIN person b ON a.user_id=b.user_id ORDER BY a.pid,b.child_order ")
    List<GenealGetout> getFenealList(JSONObject req);

    @Select("SELECT a.org_id,a.pid,a.user_id,b.username,b.epithet,b.elder_order,b.lineage,b.wife_lastname,b.remark,b.child_order FROM geneal a LEFT JOIN person b ON a.user_id=b.user_id ORDER BY a.pid,b.child_order ")
    List<Map<String,Object>> getFenealLists(JSONObject req);

    @Select("SELECT a.org_id,a.pid,a.user_id,b.username,b.epithet,b.elder_order,b.lineage,b.wife_lastname,b.remark,b.child_order FROM geneal a LEFT JOIN person b ON a.user_id=b.user_id ORDER BY a.pid,b.child_order ")
    List<GenealGetout> createData(JSONObject req);

    @Select(" select IFNULL(Max(t.org_id),0) + 1 from geneal t ")
    Integer getMaxOrgId();
}
