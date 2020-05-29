package com.imooc.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.imooc.mapper.FriendsRequestMapper;
import com.imooc.pojo.FriendsRequest;
@Service
public class FriendsRequestService{

    @Resource
    private FriendsRequestMapper friendsRequestMapper;

    
    public int deleteByPrimaryKey(String id) {
        return friendsRequestMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(FriendsRequest record) {
        return friendsRequestMapper.insert(record);
    }

    
    public int insertSelective(FriendsRequest record) {
        return friendsRequestMapper.insertSelective(record);
    }

    
    public FriendsRequest selectByPrimaryKey(String id) {
        return friendsRequestMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(FriendsRequest record) {
        return friendsRequestMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(FriendsRequest record) {
        return friendsRequestMapper.updateByPrimaryKey(record);
    }

}
