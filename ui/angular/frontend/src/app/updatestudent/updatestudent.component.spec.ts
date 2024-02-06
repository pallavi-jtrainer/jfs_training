import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatestudentComponent } from './updatestudent.component';

describe('UpdatestudentComponent', () => {
  let component: UpdatestudentComponent;
  let fixture: ComponentFixture<UpdatestudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdatestudentComponent]
    });
    fixture = TestBed.createComponent(UpdatestudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
