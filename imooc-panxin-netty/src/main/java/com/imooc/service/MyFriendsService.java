package com.imooc.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.imooc.pojo.MyFriends;
import com.imooc.mapper.MyFriendsMapper;
@Service
public class MyFriendsService{

    @Resource
    private MyFriendsMapper myFriendsMapper;

    
    public int deleteByPrimaryKey(String id) {
        return myFriendsMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MyFriends record) {
        return myFriendsMapper.insert(record);
    }

    
    public int insertSelective(MyFriends record) {
        return myFriendsMapper.insertSelective(record);
    }

    
    public MyFriends selectByPrimaryKey(String id) {
        return myFriendsMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(MyFriends record) {
        return myFriendsMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MyFriends record) {
        return myFriendsMapper.updateByPrimaryKey(record);
    }

}
