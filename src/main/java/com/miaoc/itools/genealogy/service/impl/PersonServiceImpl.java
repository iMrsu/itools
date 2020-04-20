package com.miaoc.itools.genealogy.service.impl;

import com.miaoc.itools.genealogy.entity.Person;
import com.miaoc.itools.genealogy.mapper.PersonMapper;
import com.miaoc.itools.genealogy.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-11-23
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
