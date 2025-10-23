package poly.edu.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private ObjectFactory<HttpSession> sessionFactory;

    private HttpSession getSession() {
        return sessionFactory.getObject();
    }

    public <T> T get(String name) {
        return (T) getSession().getAttribute(name);
    }

    public void set(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    public void remove(String name) {
        getSession().removeAttribute(name);
    }
}
