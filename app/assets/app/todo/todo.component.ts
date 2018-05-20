import { Component, OnInit } from '@angular/core';
import { TodoService } from './todo.service';
import { Response } from '@angular/http';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  private todos: Array<any> = [];
  private errMsg: string;
  private task: string;
  private filterMode:string;
  private isCompleted: boolean = false;

  constructor(private todoService: TodoService) { }

  ngOnInit() {
    this.getAllTodo();
  }

  getAllTodo() {
    this.todos = [];
    this.todoService.getTodoList().subscribe((response: Response) => {
      if (response.status == 200) {
        this.todos = response.json();
      } else {
        this.errMsg = "unable to fetch data"
      }

    });
  }

  /**
   * Mark task as completed in the todo List
   * @param todo 
   */
  markCompleted(todo) {
    this.todoService.markTaskComplete(todo.id).subscribe((response: Response) => {
      this.getAllTodo();
    },
      (err) => {
        this.errMsg = err;
      }
    );

  }

  deleteTask(todo) {
    this.todoService.deleteTask(todo.id).subscribe((response: Response) => {
      if (response.status == 200) {
        this.getAllTodo();
      } else {
        this.errMsg = "unable to fetch data"
      }

    });

  }
  /**
   * Create Task in the Todo List
   * @param taskData 
   */
  createTask(taskData: any) {
    

    if (taskData.valid) {
      let item: any = taskData.value;

      let todo: any = {
        description: item.task,
        title: item.task,
        isCompleted: false
      }

      this.todoService.createTask(todo).subscribe((response: Response) => {
        this.getAllTodo();
        taskData.reset();
      },
        (err) => {
          this.errMsg = err;
        }
      );
    }


  }

  filterData(mode:string){
    
    if(this.isCompleted){
      this.filterMode = mode;
      this.isCompleted = false;
    }else{
      this.filterMode = undefined;
      this.isCompleted = true;
    }

  }


}
