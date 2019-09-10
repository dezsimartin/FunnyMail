package hu.flowacademy.FunnyMail.repositories;

import hu.flowacademy.FunnyMail.exceptions.EntityNotFoundException;
import hu.flowacademy.FunnyMail.models.MessageModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MessageRepository {

    List<MessageModel> messages = new ArrayList<>();

    public List<MessageModel> findAll(){
        return messages;
    }

    public MessageModel findOne(UUID id){
        return messages.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public MessageModel save(MessageModel messageModel){
            if(messageModel.getId() == null){
                
            }
    }
}
