package controllers;

import play.mvc.*;

import play.libs.Json;
import java.util.*;
import models.TodoBean;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result getTodos(){
        List<TodoBean> todos=getTodoList();
        return ok(Json.toJson(todos));
    }

    public List<TodoBean> getTodoList(){
        List<TodoBean> todos = new ArrayList<TodoBean>();
        todos.add(new TodoBean("Complete the design"));
        todos.add(new TodoBean("Complete the code"));
        todos.add(new TodoBean("Complete the unit Test"));
        todos.add(new TodoBean("Send deleverables to client"));
        return todos;
    }

}
