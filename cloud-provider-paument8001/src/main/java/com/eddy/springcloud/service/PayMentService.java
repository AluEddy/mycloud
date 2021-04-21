package com.eddy.springcloud.service;

import com.eddy.springcloud.entity.PayMent;

public interface PayMentService {
    public int creat(PayMent payMent);

    public PayMent getById(Long id);
}
