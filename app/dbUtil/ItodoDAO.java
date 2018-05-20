package dbUtil;

import java.util.List;

import models.TodoBean;

public interface ItodoDAO {
	public List<TodoBean> findAll();
	public TodoBean findById();
	public List<TodoBean> findByStatus();
	public boolean addTodo(TodoBean todo);
	public boolean markComplete(int id, boolean status);
	public boolean deleteTodo(int id);
	

}
