package app.services.interfaces;

import javax.jms.ObjectMessage;

public interface QueueReciever {
    void simpleTextReciever(String msg);
    void customJmsMessageReciever(ObjectMessage msg);
}
