package cn.bdqn.service;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void add(String username, String password) {
        userMapper.add(username,password);
    }

    @Override
    public void update(String username, Integer id) {
        userMapper.update(username,id);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public PageBean<User> findlimit(Integer currPageNo, Integer pageSize) {
        PageBean<User>pageBean = new PageBean<User>();
        pageBean.setCurrPageNo(currPageNo);
        pageBean.setPageSize(pageSize);
        int total = userMapper.findTotal();
        pageBean.setTotalCount(total);
        int totalPageCount = total%pageSize==0?total/pageSize:total/pageSize+1;
        pageBean.setTotalPageCount(totalPageCount);
        List<User>list = userMapper.findlimit((currPageNo-1)*pageSize,pageSize);
        pageBean.setLists(list);
        return pageBean;
    }

    @Override
    public Integer findTotal() {
        return userMapper.findTotal();
    }
}
