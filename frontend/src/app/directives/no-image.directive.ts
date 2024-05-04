import {
  Directive,
  ElementRef,
  Host,
  HostListener,
  Renderer2,
} from '@angular/core';

@Directive({
  selector: '[appNoImage]',
})
export class NoImageDirective {
  constructor(private nodoDOM: ElementRef, private renderer: Renderer2) {}

  /*@HostListener decora el metodo onError() como un listener de eventos que se activa cuando se produce un evento error en el elemento DOM al que esta anotado.*/
  @HostListener('error')
  onError(): void {
    /* El primer argumento de serAttributte es el elemento del DOM en el que esta situada la directiva
    El segundo argumento es el nombre del atributo cuyo contenido queremos cambiar.
    El tercer argumento es el valor que queremos sustituir*/
    this.renderer.setAttribute(
      this.nodoDOM.nativeElement,
      'src',
      'assets/img/no-image.jpg'
    );
  }
}
