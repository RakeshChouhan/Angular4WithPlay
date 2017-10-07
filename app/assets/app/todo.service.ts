import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Todo} from './todo'
@Injectable()
export class TodoService{
    private todoUrl = "/todoList";
    constructor(private http:Http){

    }
  /*  getTodos(){
        return "Hello Dear";
    }*/
    getTodos():Promise<Array<Todo>>{
        return this.http.get(this.todoUrl).toPromise().then((response)=>{
            let result = response.json() as Todo[];
            return result;
        });
    }
}