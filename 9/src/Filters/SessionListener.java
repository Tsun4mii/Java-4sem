package Filters;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener
        implements HttpSessionAttributeListener {
    public void attributeRemoved(HttpSessionBindingEvent ev) {
    }

    public void attributeAdded(HttpSessionBindingEvent ev) {
// запись в log-файл или иные действия
        System.out.println("добавлен: " + ev.getClass().getSimpleName()
                + " : " + ev.getName()
                + " : " + ev.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent ev) {
// запись в log-файл или иные действия
        System.out.println("изменён: " + ev.getClass().getSimpleName()
                + " : " + ev.getName()
                + " : " + ev.getValue());
    }
}