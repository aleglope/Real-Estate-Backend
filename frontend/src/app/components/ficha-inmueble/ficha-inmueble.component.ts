import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-ficha-inmueble',
  templateUrl: './ficha-inmueble.component.html',
  styleUrl: './ficha-inmueble.component.css',
})
export class FichaInmuebleComponent {
  @Input() datos: any; //aqui estan todos los datos del inmueble incluidas las imagenes
}
