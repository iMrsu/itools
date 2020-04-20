package com.miaoc.itools.genealogy.service;

import com.alibaba.fastjson.JSONObject;
import com.miaoc.itools.genealogy.entity.GenealGetInput;
import com.miaoc.itools.genealogy.entity.GenealGetout;
import com.miaoc.itools.genealogy.entity.Genealogy;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
public interface IGenealogyService extends IService<Genealogy> {

    List<GenealGetout> getFenealList(JSONObject req);

    List<Map<String,Object>> getFenealLists(JSONObject req);

    GenealGetout createData(GenealGetInput req);

    GenealGetout updateData(GenealGetInput req);

    GenealGetout deleteData(GenealGetInput req);
}
