package anis.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ActiveMember;
import entities.Message;
import entities.Notification;

@Local
public interface MessageServiceLocal {
	Boolean ajouterMessage(Message message,Notification notification);
	List<Message> readAllMessage();
	Boolean deleteMessageById(Integer id);
	Boolean updateMessage(Message message);	
	Message findMessageById(Integer id);
    ActiveMember findActiveMemeberByUsername(String username);
    ActiveMember findActiveMemberById(Long long1);
    ActiveMember findActiveMemberByEmail(String email);
    List<Message> readAllMessageByIDActiveMember(ActiveMember activeMember);

}
