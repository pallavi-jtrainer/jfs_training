import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { HttpClientModule } from '@angular/common/http';
import { ShowdetailsComponent } from './showdetails/showdetails.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { UpdatestudentComponent } from './updatestudent/updatestudent.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    StudentlistComponent,
    ShowdetailsComponent,
    UpdatestudentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
