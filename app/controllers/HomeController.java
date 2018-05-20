package controllers;

import java.util.ArrayList;
import java.util.List;

import dbUtil.ItodoDAO;
import dbUtil.TodoDAO;
import models.TodoBean;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

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
	private ItodoDAO todoDAO = new TodoDAO();
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @Transactional
    public Result getTodos(){
    	return ok(Json.toJson(todoDAO.findAll()));
    }
    
    @Transactional
    public Result addTodo() {
    	TodoBean todo = Json.fromJson(request().body().asJson(), TodoBean.class);
    	return ok(Json.toJson(String.format("{status:%s}", todoDAO.addTodo(todo))));
    	
    }
    
    @Transactional
    public Result markAsComplete(int id, boolean status) {
    	return ok(Json.toJson(String.format("{status:%s}", todoDAO.markComplete(id, status))));
    }
    
    @Transactional
    public Result deleteTodo(int id) {
    	return ok(Json.toJson(String.format("{status:%s}", todoDAO.deleteTodo(id))));
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
