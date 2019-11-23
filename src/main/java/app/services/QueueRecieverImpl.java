package app.services;

import app.services.interfaces.QueueReciever;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class QueueRecieverImpl implements QueueReciever {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @JmsListener(destination = "simpleTextQueue.q")
    public void simpleTextReciever(String msg) {
        logger.info("Message from simipleTextQueue " + msg);
    }
}
