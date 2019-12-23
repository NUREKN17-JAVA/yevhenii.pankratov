package ua.nure.kn.pankratov.usermanagement.web;

import ua.nure.kn.pankratov.usermanagement.User;
import ua.nure.kn.pankratov.usermanagement.db.DaoFactory;
import ua.nure.kn.pankratov.usermanagement.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends EditServlet {

    protected void ShowPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    protected void ProccesUser(User user) throws DatabaseException {
        DaoFactory.getInstance().getUserDao().create(user);
    }
}