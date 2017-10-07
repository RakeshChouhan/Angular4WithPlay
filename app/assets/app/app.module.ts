import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { TodoComponent } from './todo.component';
import { TodoService }  from './todo.service'


@NgModule({
  imports: [
    BrowserModule,
    HttpModule
  ],
  declarations: [
    TodoComponent
  ],
  providers: [TodoService],
  bootstrap: [TodoComponent]
})
export class AppModule { }