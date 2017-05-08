import { Component, OnInit } from '@angular/core';
import { Student } from '../student.model';
import {StudentService} from '../services/student.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'student-root',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
  providers:[StudentService]
})
export class studentComponent implements OnInit{
 
    
    constructor(private studentService : StudentService){};
     public content : Student[];
    retrieveList(){
        this.studentService.retrieveList().subscribe(
        student => this.content = student);
            
        }
    
    ngOnInit(){
        this.retrieveList();
        
        }
  
}

