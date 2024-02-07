import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { HttpClientModule } from '@angular/common/http';
import { ShowdetailsComponent } from './showdetails/showdetails.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { UpdatestudentComponent } from './updatestudent/updatestudent.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddStudentComponent } from './add-student/add-student.component';
import { PasswordPatternDirective } from './directives/password-pattern.directive';
import { MatchPasswordDirective } from './directives/match-password.directive';
import { EmailPatternDirective } from './directives/email-pattern.directive';
import { ReactiveRegistrationFormComponent } from './reactive-registration-form/reactive-registration-form.component';
//import { RegistrationFormReactiveComponent } from './registration-form-reactive/registration-form-reactive.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentlistComponent,
    ShowdetailsComponent,
    UpdatestudentComponent,
    AddStudentComponent,
    PasswordPatternDirective,
    MatchPasswordDirective,
    EmailPatternDirective,
    ReactiveRegistrationFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
