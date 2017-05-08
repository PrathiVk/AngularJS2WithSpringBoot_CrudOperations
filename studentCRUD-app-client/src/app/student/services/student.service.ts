import { Injectable } from "@angular/core";
import {Http, Response} from "@angular/http";
import {Student} from '../student.model';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class StudentService{
        constructor (private http: Http) {
        }
        
        retrieveList(){
            return this.http.get('/api/student/')
            .map( 
                response => <Student[]> response.json());
                
            
            }
        
}