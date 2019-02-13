package net.seehope.college.service;

import net.seehope.college.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> selectall();

    public void addMessage(Message message);
}
