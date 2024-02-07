import { Injectable } from '@angular/core';
import { AbstractControl, FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CustomvalidationService {

  constructor() { }

  static MatchPassword(pass: string, confirm: string) {
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[pass];
      const confirmPassword = formGroup.controls[confirm];

      if (!passwordControl || !confirmPassword) return null;

      if(confirmPassword?.errors && !confirmPassword.errors['passwordMismatch']) return null;

      if(passwordControl.value !== confirmPassword.value) {
        confirmPassword?.setErrors({passwordMismatch: true})
      } else {
        confirmPassword?.setErrors(null);
      }

    }
  }

  emailValidator(): ValidatorFn {
    return (control: AbstractControl): {[key:string]: any | undefined } => {
      if(!control.value) {
        return null as any;
      }
      const regex = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])@[a-z].[a-z]$');
      const valid = regex.test(control.value);
      return valid ? null as any : {invalidEmail: true}
    };
  }

  passwordPatternValidator(): ValidatorFn {
    return (control: AbstractControl): {[key:string]: any | undefined} => {
      if(!control.value) {
        return null as any;
      }
      const regex = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8, 15}$');
      const valid = regex.test(control.value);
      return valid ? null as any : {invalidPassword: true}
    };
  }
}
