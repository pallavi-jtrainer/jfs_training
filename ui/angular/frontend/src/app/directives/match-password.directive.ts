import { Directive, Input } from '@angular/core';
import { AbstractControl, FormGroup, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';
import { CustomvalidationService } from '../services/customvalidation.service';

@Directive({
  selector: '[appMatchPassword]',
  providers: [{provide: NG_VALIDATORS, useExisting: MatchPasswordDirective, multi: true}]
})
export class MatchPasswordDirective implements Validator{

  @Input('appMatchPassword') matchPassword: string[] = [];

  //constructor(private customValidator: CustomvalidationService) { }

  // validate(control: AbstractControl<any, any>): ValidationErrors | null {
  //     return this.customValidator.MatchPassword(this.matchPassword[0], this.matchPassword[1]);
  // }

  validate(formGroup: FormGroup): ValidationErrors | null {
    return CustomvalidationService.MatchPassword(this.matchPassword[0], this.matchPassword[1])(formGroup);
  }
}
