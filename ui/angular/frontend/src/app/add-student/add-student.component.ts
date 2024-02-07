import { Component } from '@angular/core';
import { Student } from '../models/Student';
import { Router } from '@angular/router';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {
[x: string]: any;
 student: Student = new Student();
 pass: string = '';
 confirm: string = '';

 constructor(private router: Router,private studentService: StudentService) {}

 onSubmit() {
  // if(this.pass === this.confirm) {
  //   this.student.password = this.pass;
  //   console.log(this.student);
  // }
 // console.log(this.student)
  this.studentService.createStudent(this.student)
    .subscribe(data => {
      console.log(data);
    });
 }
}
