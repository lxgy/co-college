package net.seehope.college.service.impl;

import net.seehope.college.entity.Message;
import net.seehope.college.mapper.MessageMapper;
import net.seehope.college.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageMapper mapper;

    @Override
    public List<Message> selectall() {
        return mapper.getAllMessage();
    }

    @Override
    public void addMessage(Message message) {
        mapper.addMessage(message);
    }
}
