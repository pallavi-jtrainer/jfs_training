import { Directive } from '@angular/core';
import { CustomvalidationService } from '../services/customvalidation.service';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[appEmailPattern]',
  providers: [{provide: NG_VALIDATORS, useExisting: EmailPatternDirective, multi: true}]
})
export class EmailPatternDirective implements Validator {

  constructor(private customerValidator: CustomvalidationService) { }

  validate(control: AbstractControl<any, any>): ValidationErrors | null {
      return this.customerValidator.emailValidator()(control);
  }
}
