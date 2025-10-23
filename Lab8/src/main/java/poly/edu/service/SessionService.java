package poly.edu.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {

    @Autowired
    private ObjectFactory<HttpSession> sessionFactory;

    private HttpSession getSession() {
        return sessionFactory.getObject();
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) getSession().getAttribute(name);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) getSession().getAttribute(name);
        return value != null ? value : defaultValue;
    }

    public void set(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    public void remove(String name) {
        getSession().removeAttribute(name);
    }
}
