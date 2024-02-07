import { Component } from '@angular/core';
import { Student } from '../models/Student';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-updatestudent',
  templateUrl: './updatestudent.component.html',
  styleUrls: ['./updatestudent.component.css']
})
export class UpdatestudentComponent {
  student: Student = new Student();

  newPass: string = '';

  constructor(private router: Router, private studentService:StudentService,
    private route:ActivatedRoute) {}

  ngOnInit() {
    let id = this.route.snapshot.params['id'];
    this.loadContent(id);
  }

  loadContent(id:number) {
    this.studentService.getStudent(id).subscribe(data =>{
      this.student = data;
    })
  }

  updateStudentDetails() {
    this.student.password = this.newPass;
    // console.log(this.student.password);
    this.studentService.updatePassword(this.student)
      .subscribe(data => {
        console.log(data);
        // window.location.reload();
        this.router.navigate(['home']);
      })
  }

  returnToHome() {
    this.router.navigate(['home']);
  }
}
