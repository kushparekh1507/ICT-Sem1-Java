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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueBean2 implements MessageListener {
    
    public QueueBean2() {
    }
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage text=(TextMessage) message;
            try {
                System.out.println("QueueBean2 : "+text.getText());
            } catch (JMSException ex) {
                Logger.getLogger(QueueBean1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
