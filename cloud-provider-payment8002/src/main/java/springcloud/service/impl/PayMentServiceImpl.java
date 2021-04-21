package springcloud.service.impl;

import com.eddy.springcloud.entity.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springcloud.dao.PayMentDao;
import springcloud.service.PayMentService;

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
