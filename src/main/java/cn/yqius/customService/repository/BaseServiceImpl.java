package cn.yqius.customService.repository;

import cn.yqius.customService.repository.Inter.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {
    @Override
    public void test() {
        System.out.println("调用service服务");
    }
}