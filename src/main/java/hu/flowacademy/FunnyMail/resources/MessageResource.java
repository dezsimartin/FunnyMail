package hu.flowacademy.FunnyMail.resources;

import hu.flowacademy.FunnyMail.models.MessageDTO;
import hu.flowacademy.FunnyMail.models.MessageModel;
import hu.flowacademy.FunnyMail.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/api/")
public class MessageResource {

    @Autowired
    private UserService userService;

    public MessageModel convertToMessage(MessageDTO m){
        UUID from = UUID.fromString(m.getFromId());
        UUID to = UUID.fromString(m.getToId());
        return new MessageModel(m.getId(), userService.findOne(from), userService.findOne(to), m.getContent(), LocalDateTime.now());
    }


}
