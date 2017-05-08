import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';
import { RouterModule }  from '@angular/router';

import { AppComponent } from './app.component';
import { studentComponent } from './student/component/student.component';
import { StudentService } from './student/services/student.service';


@NgModule({
  declarations: [
    AppComponent,
      studentComponent
      
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
