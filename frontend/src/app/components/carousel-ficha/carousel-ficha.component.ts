import { Component, Input, OnInit } from '@angular/core';
import { GLOBAL } from '../../environments/global';

@Component({
  selector: 'app-carousel-ficha',
  templateUrl: './carousel-ficha.component.html',
  styleUrl: './carousel-ficha.component.css'
})
export class CarouselFichaComponent{


  @Input() datosCarousel:any;//aquí están todos los datos del inmueble
    url:string = GLOBAL.url_imagen;


}
