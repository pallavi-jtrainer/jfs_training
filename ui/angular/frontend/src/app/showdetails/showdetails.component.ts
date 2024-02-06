import { Component } from '@angular/core';
import { Student } from '../models/Student';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-showdetails',
  templateUrl: './showdetails.component.html',
  styleUrls: ['./showdetails.component.css']
})
export class ShowdetailsComponent {

  student: Student = new Student();

  constructor(private router: Router, private studentService: StudentService,
    private route: ActivatedRoute) {}

  ngOnInit() {
    let id = this.route.snapshot.params['id'];
    this.loadContent(id);
  }

  loadContent(id: number) {
    this.studentService.getStudent(id)
      .subscribe(data => {
        this.student = data;
        console.log(this.student);
      })
  }
}
