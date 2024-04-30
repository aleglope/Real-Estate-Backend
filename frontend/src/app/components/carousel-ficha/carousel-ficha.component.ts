import { Component, Input, OnInit } from '@angular/core';
import { GLOBAL } from '../../environments/global';

@Component({
  selector: 'app-carousel-ficha',
  templateUrl: './carousel-ficha.component.html',
  styleUrl: './carousel-ficha.component.css'
})
export class CarouselFichaComponent implements OnInit {

  @Input() datosCarousel:any; //aqui estan todos los datos del inmueble
    url:string=GLOBAL.url_imagen; //aqui esta la url de la imagen

    ngOnInit(): void {
      console.log(this.datosCarousel);
    }
}
