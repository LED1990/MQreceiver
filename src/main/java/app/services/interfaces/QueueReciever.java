package app.services.interfaces;

import app.model.CustomJmsMessage;

import javax.jms.ObjectMessage;

public interface QueueReciever {
    void simpleTextReciever(String msg);
    void customJmsMessageReciever(ObjectMessage msg);
}
