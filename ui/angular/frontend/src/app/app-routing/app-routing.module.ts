import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { StudentlistComponent } from '../studentlist/studentlist.component';
import { ShowdetailsComponent } from '../showdetails/showdetails.component';
import { UpdatestudentComponent } from '../updatestudent/updatestudent.component';

const routes: Routes = [
  {path: 'home', component: StudentlistComponent},
  {path: 'details/:id', component: ShowdetailsComponent},
  {path: 'update/:id', component: UpdatestudentComponent},
  {path: '', pathMatch: 'full', component: StudentlistComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
