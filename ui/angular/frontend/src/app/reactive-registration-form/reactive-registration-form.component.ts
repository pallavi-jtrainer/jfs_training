import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomvalidationService } from '../services/customvalidation.service';
import { Student } from '../models/Student';

@Component({
  selector: 'app-reactive-registration-form',
  templateUrl: './reactive-registration-form.component.html',
  styleUrls: ['./reactive-registration-form.component.css']
})
export class ReactiveRegistrationFormComponent {

  student: Student = new Student();

  submitted = false;

  pass = '';
  confirm = '';

  registerationForm: FormGroup = new FormGroup({
    firstname: new FormControl(''),
    lastName: new FormControl('Enter Last Name', [Validators.required, Validators.minLength(5)]),
    emailAddress: new FormControl('Enter Email Address', [Validators.required, Validators.email]),
    phone: new FormControl('Enter Phone Number',
      [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
    password: new FormControl('Enter Password',
      [Validators.required, Validators.minLength(8), Validators.maxLength(15)]),
    confirmPassword: new FormControl('Confirm Password',
      [Validators.required, Validators.minLength(8), Validators.maxLength(15)])
  });

  constructor(private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    this.registerationForm = this.formBuilder.group(
      {
        firstname: ['', [Validators.required, Validators.minLength(5)]],
        lastName: ['', [Validators.required, Validators.minLength(5)]],
        emailAddress: ['', [Validators.required, Validators.email]],
        phone: ['',
          [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
        password: ['',
          [Validators.required, Validators.minLength(8), Validators.maxLength(15)]],
        confirmPassword: ['',
          [Validators.required, Validators.minLength(8), Validators.maxLength(15)]]
      },
      {
      validators: [CustomvalidationService.MatchPassword('password', 'confirmPassword')]
    })
  }

  get f() :{[key: string]: AbstractControl} {
      return this.registerationForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if(this.registerationForm.valid) {
      this.student = this.registerationForm.value
      console.log(this.student);
    } else {
      console.log("Form Invalid")
    }

  }
}
