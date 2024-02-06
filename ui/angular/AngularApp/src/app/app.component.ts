import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // template:`
  //   <div>
  //     <h2>This is an inline html template</h2>
  //     <p>{{title}}</p>
  //   </div>
  // `,
  // styleUrls: ['./app.component.css']
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // title = 'My First Angular Application';
  // abc = 'Some new data';
  data: string = 'This is the value from the app.component.ts file';

  onSignUp(data: any) {
    let str = "Thank you for registering " + data.fullname
      + ". Your Id is" + data.id;
    alert(str);
  }
}
