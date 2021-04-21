package com.eddy.springcloud.service.impl;

import com.eddy.springcloud.dao.PayMentDao;
import com.eddy.springcloud.entity.PayMent;
import com.eddy.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PayMentServiceImpl implements PayMentService {

    @Resource
    PayMentDao payMentDao;

    @Override
    public int creat(PayMent payMent) {
        return payMentDao.creat(payMent);
    }

    @Override
    public PayMent getById(Long id) {
        return payMentDao.getById(id);
    }
}
