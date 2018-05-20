package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TodoBean")
public class TodoBean{
	
	@Id	
	@GeneratedValue
	private int id;
	
	@Column(name="title")
    private String title;
	
	@Column(name="description")
    private String description;
	
	
	
	@Column(name="isCompleted")
    private boolean isCompleted;
   
	public TodoBean() {}
	
    public TodoBean(String task){
        this.title = task;
    }
    
    public TodoBean(int id, String task, String description, boolean status) {
    	this.id=id;
    	this.title = task;
    	this.description = description;
    	this.isCompleted = status;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}