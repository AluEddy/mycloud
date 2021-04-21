package springcloud.dao;

import com.eddy.springcloud.entity.PayMent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMentDao {
    int creat(PayMent payMent);

    PayMent getById(Long id);
}
