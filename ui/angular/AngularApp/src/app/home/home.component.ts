import { identifierName } from '@angular/compiler';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  s = {
    id: 0,
    studentName: "",
    age: 0
  };

  students = [{
    id: 1, studentName: 'student1', age: 12
  },{
    id: 2, studentName: 'student2', age: 13
  }, {
    id: 3, studentName: 'student3', age: 12
  },{
    id: 4, studentName: 'student4', age: 12
  }];

  getStudentDetails(id: number) {
    let s = this.students.filter(s1 => s1.id === id);
    console.log(s);
    // let s = undefined;
    // for(let i = 0; i < this.students.length; i++)  {
    //   if(this.students[i].id === id) {
    //     s = this.students[i];
    //     break;
    //   }
    // }
    // console.log(s);
  }

  addStudentDetails() {
    this.students.push(this.s);
  }
}
