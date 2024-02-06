import { Component } from '@angular/core';
import { Student } from '../models/Student';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-studentlist',
  templateUrl: './studentlist.component.html',
  styleUrls: ['./studentlist.component.css']
})
export class StudentlistComponent {
  students: Student[] = [];

  constructor(private studentService: StudentService,
    private route: Router) {}

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.studentService.getAllStudents()
      .subscribe(data => {
        data.forEach(student => {
          this.students.push(student);
        });
       // console.log(data);
        // this.students = data;
        console.log("students: ", this.students);
      })
  }

  showDetails(id: number) {
    this.route.navigate(['/details/', id]);
  }
}
