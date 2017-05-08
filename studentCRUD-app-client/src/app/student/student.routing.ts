import  { Routes, RouterModule } from '@angular/roconstuter';
import { StudentComponent } from './student.component';

const studentRoutes : Routes = [

    {path: 'student', component: StudentComponent, pathMatch:'full'},
    {path: 'student/add', component:StudentComponent},
    {path: 'student/:id', component:StudentComponent}
    
    ];

export const studentRouting = RouterModule.forChild(studentRoutes);