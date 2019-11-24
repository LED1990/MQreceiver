package app.services;

import app.model.CustomJmsMessage;
import app.services.interfaces.QueueReciever;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Service
public class QueueRecieverImpl implements QueueReciever {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @JmsListener(destination = "simpleTextQueue.q")
    public void simpleTextReciever(String msg) {
        logger.info("Message from simipleTextQueue " + msg);
    }

    @Override
    @JmsListener(destination = "customJmsMessage.q")
    public void customJmsMessageReciever(ObjectMessage msg){
        CustomJmsMessage customJmsMessage = null;
        try {
            if (msg.getObject() instanceof CustomJmsMessage){
               customJmsMessage = (CustomJmsMessage) msg.getObject();
            }
        } catch (JMSException e) {
            logger.error("",e);
        }

        if (customJmsMessage != null){
            logger.info("Message from customJmsMessage " + customJmsMessage.getMsg());
        }else {
            logger.info("Failed");
        }
    }
}
