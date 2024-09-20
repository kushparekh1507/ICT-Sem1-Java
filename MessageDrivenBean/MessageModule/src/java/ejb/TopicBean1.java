/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author DELL
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "client1"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class TopicBean1 implements MessageListener {
    
    public TopicBean1() {
    }
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage text=(TextMessage) message;
            try {
                System.out.println("TopicBean1 : "+text.getText());
            } catch (JMSException ex) {
                Logger.getLogger(QueueBean1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
