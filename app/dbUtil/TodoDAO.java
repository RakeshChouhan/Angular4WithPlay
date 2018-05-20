/**
 * 
 */
package dbUtil;

import java.util.List;

import javax.persistence.EntityManager;

import models.TodoBean;
import play.db.jpa.JPA;

/**
 * @author Rakesh
 *
 */
public class TodoDAO implements ItodoDAO {
	
	

	@Override
	public List<TodoBean> findAll() {
		return JPA.em().createQuery("select t from TodoBean t", TodoBean.class).getResultList();
		
	}

	@Override
	public TodoBean findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoBean> findByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTodo(TodoBean todo) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			JPA.em().persist(todo);
			result = true;
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean markComplete(int id, boolean status) {
		return JPA.em().createQuery("update TodoBean t set t.isCompleted='"+status+"' where t.id="+id).executeUpdate()>0;
	}

	@Override
	public boolean deleteTodo(int id) {
		return JPA.em().createQuery("delete from TodoBean t where t.id="+id).executeUpdate()>0;
	}

}
