package bsu.rfe.group9.Krasilnikova.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import bsu.rfe.group9.Krasilnikova.entity.Ad;
import bsu.rfe.group9.Krasilnikova.entity.AdList;
import bsu.rfe.group9.Krasilnikova.entity.UserList;
import bsu.rfe.group9.Krasilnikova.helper.AdListHelper;
import bsu.rfe.group9.Krasilnikova.UserListHelper;
// Сервлет загружается автоматически при запуске приложения
public class StartupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // В методе инициализации будут создаваться общие структуры данных
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
// Загрузить список пользователей
        UserList userList = UserListHelper.readUserList(getServletContext());
// Сохранить список пользователей в контексте сервлета
// (для JSP это тождественно равно applicationContext)
        getServletContext().setAttribute("users", userList);
// Загрузить список сообщений
        AdList adList = AdListHelper.readAdList(getServletContext());
// Сохранить список объявлений в контексте сервлета
// (для JSP это тождественно равно applicationContext)
        getServletContext().setAttribute("ads", adList);
        for (Ad ad: adList.getAds()) {
// Т.к. в сообщениях изначально присутствует только id автора, для удобства установим ссылки
            ad.setAuthor(userList.findUser(ad.getAuthorId()));
// Инициализировать значения свойства lastModifiedDate
            ad.setLastModified(ad.getLastModified());
        }
    }
}