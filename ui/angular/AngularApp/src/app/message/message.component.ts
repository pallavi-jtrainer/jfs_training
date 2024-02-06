import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent {
  // @Input()
  // @Input('message')
  // msg: string = '';

  // showMessage() {
  //   alert(this.msg);
  // }

  student = {
    id: 0,
    fullname:''
  };

  @Output()
  onRegisteration = new EventEmitter();

  onSubmit() {
    this.onRegisteration.emit(this.student);
  }
}
