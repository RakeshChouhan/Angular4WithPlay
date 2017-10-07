import { Component, OnInit} from '@angular/core'

import{ TodoService } from './todo.service'

import {Todo} from './todo'

@Component({
    selector:'todo-root',
    templateUrl:'./templates/todoList.html'
})
export class TodoComponent implements OnInit {
    todos : Todo[];
    constructor(private todoService:TodoService){}
    title="Todo App";

    ngOnInit(){
         this.todoService.getTodos().then(todos=>this.todos=todos);
        

    }



 
}