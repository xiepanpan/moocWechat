package com.imooc.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.imooc.mapper.ChatMsgMapper;
import com.imooc.pojo.ChatMsg;
@Service
public class ChatMsgService{

    @Resource
    private ChatMsgMapper chatMsgMapper;

    
    public int deleteByPrimaryKey(String id) {
        return chatMsgMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(ChatMsg record) {
        return chatMsgMapper.insert(record);
    }

    
    public int insertSelective(ChatMsg record) {
        return chatMsgMapper.insertSelective(record);
    }

    
    public ChatMsg selectByPrimaryKey(String id) {
        return chatMsgMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(ChatMsg record) {
        return chatMsgMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(ChatMsg record) {
        return chatMsgMapper.updateByPrimaryKey(record);
    }

}
