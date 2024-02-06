import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { StudentlistComponent } from '../studentlist/studentlist.component';
import { ShowdetailsComponent } from '../showdetails/showdetails.component';

const routes: Routes = [
  {path: 'home', component: StudentlistComponent},
  {path: 'details/:id', component: ShowdetailsComponent},
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
