import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';
import { CustomvalidationService } from '../services/customvalidation.service';
// import { MatchPasswordDirective } from './match-password.directive';

@Directive({
  selector: '[appPasswordPattern]',
  providers: [{provide: NG_VALIDATORS, useExisting: PasswordPatternDirective, multi: true}]
})
export class PasswordPatternDirective implements Validator{

  constructor(private customValidator: CustomvalidationService) { }

  validate(control: AbstractControl<any, any>): ValidationErrors | null {
    return this.customValidator.passwordPatternValidator()(control);
  }

  // registerOnValidatorChange?(fn: () => void): void {
  //   throw new Error('Method not implemented.');
  // }

}
