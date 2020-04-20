package com.miaoc.itools.genealogy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNullFormatVisitor;
import com.miaoc.itools.genealogy.entity.GenealGetInput;
import com.miaoc.itools.genealogy.entity.GenealGetout;
import com.miaoc.itools.genealogy.entity.Genealogy;
import com.miaoc.itools.genealogy.entity.Person;
import com.miaoc.itools.genealogy.mapper.GenealogyMapper;
import com.miaoc.itools.genealogy.mapper.PersonMapper;
import com.miaoc.itools.genealogy.service.IGenealogyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoc.itools.utils.BaseUtils;
import com.miaoc.itools.utils.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
@Service("iGenealogyService")
public class GenealogyServiceImpl extends ServiceImpl<GenealogyMapper, Genealogy> implements IGenealogyService {

    @Resource
    private GenealogyMapper genealogyMapper;

    @Resource
    private PersonMapper personMapper;

    @Resource
    private BaseUtils baseUtils;
    @Override
    public List<GenealGetout> getFenealList(JSONObject req) {
        List<GenealGetout> output = genealogyMapper.getFenealList(req);
        output = getDeptTree(output,"");
        return output;
    }
    @Override
    public List<Map<String,Object>> getFenealLists(JSONObject req) {
        List<Map<String,Object>> output = genealogyMapper.getFenealLists(req);
        return output;
    }

    @Override
    public GenealGetout createData(GenealGetInput input) {
        GenealGetout output = new GenealGetout();
        Genealogy genealogy = new Genealogy();
        Person person = new Person();
        BaseUtils.ValueCopy(input,person);
        person.setUserId(baseUtils.getUUID());
        genealogy.setOrgId(baseUtils.getUUID());
        genealogy.setPid(input.getOrgId());
        genealogy.setUserId(person.getUserId());
        genealogyMapper.insert(genealogy);
        personMapper.insert(person);
        return output;
    }

    @Override
    public GenealGetout updateData(GenealGetInput input) {
        GenealGetout output = new GenealGetout();
        Genealogy genealogy = new Genealogy();
        Person person = new Person();
        BaseUtils.ValueCopy(input,genealogy);
        BaseUtils.ValueCopy(input,person);
        genealogy.setUserId(person.getUserId());
        genealogyMapper.updateById(genealogy);
        personMapper.updateById(person);
        return output;
    }
    @Override
    public GenealGetout deleteData(GenealGetInput input) {
        GenealGetout output = new GenealGetout();
        /**获取列表所有数据*/
        List<GenealGetout> objList = genealogyMapper.getFenealList(new JSONObject());
        List<GenealGetout> listDelBatchIds = new ArrayList<>();
        GenealGetout genealGetout = new GenealGetout();
        BaseUtils.ValueCopy(input,genealGetout);
        /**被删除的数据*/
        listDelBatchIds.add(genealGetout);
        listDelBatchIds.addAll(getBatchIds(objList,input.getOrgId()));
        List<String> listPerson = new ArrayList<>();
        List<String> listGenealogy = new ArrayList<>();
        for(GenealGetout geneal:listDelBatchIds){
            listPerson.add(geneal.getUserId());
            listGenealogy.add(geneal.getOrgId());
        }
        genealogyMapper.deleteBatchIds(listGenealogy);
        personMapper.deleteBatchIds(listPerson);
        return output;
    }
    /**
     * 二维数组转树
     */
    public static List<GenealGetout> getDeptTree(List<GenealGetout> list,String pid){
        List<GenealGetout> result =  new ArrayList<GenealGetout>();
        List<GenealGetout> temp =  new ArrayList<GenealGetout>();
        for(GenealGetout entity : list){
            if(entity.getPid().equals(pid)){
                GenealGetout deptScopeMode = new GenealGetout();
                BaseUtils.ValueCopy(entity,deptScopeMode);
                temp = getDeptTree(list,entity.getOrgId());
                if(temp.size() > 0){
                    deptScopeMode.setChildren(temp);
                }
                result.add(deptScopeMode);
            }
        }
        return result;
    }

    /**
     * 查找所有子节点
     */
    public static List<GenealGetout> getBatchIds(List<GenealGetout> objList,String id){
        List<GenealGetout> listGenealGetout = new ArrayList<>();
        for(GenealGetout geneal:objList){
            if(id.equals(geneal.getPid())){
                listGenealGetout.add(geneal);
                listGenealGetout.addAll(getBatchIds(objList,geneal.getOrgId()));
            }
        }
        return listGenealGetout;
    }
}
