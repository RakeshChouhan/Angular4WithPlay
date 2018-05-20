import { Injectable } from '@angular/core';
import { Http } from '@angular/http'

@Injectable()
export class TodoService {

  constructor(private http:Http) { }

  getTodoList(){
    return this.http.get("/api/todos");
  }
  createTask(todo:any){
    return this.http.post("/api/todo",todo);
  }
  markTaskComplete(id:number){
    return this.http.put("/api/todo/"+id+"/true",{});
  }
  deleteTask(id:number){
    return this.http.delete("/api/todo/"+id);
  }

}
