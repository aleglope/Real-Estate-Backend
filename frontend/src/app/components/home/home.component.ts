import { Component } from '@angular/core';
import { BannerHorizontal } from '../../models/utils';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  usuario:string = "";

    datos1:BannerHorizontal = {
    altImagen:"Chica con gafas pensando",
    imagen:"assets/img/banner-agencias-inmobiliarias.jpg",
    titular:"Te recomendamos las agencias inmobiliarias más adecuadas para vender tu casa",
    claim:"Seleccionamos hasta 4 agencias, según sean las características de tu inmueble, que te ayudarán a vender rápidamente.",
    link:"#",
    textoLink:"Buscar una agencia inmobiliaria"

  }

  datos2:BannerHorizontal={

  altImagen:"Persona consultando una tablet",
  imagen:"assets/img/banner-cuanto-vale-tu-casa.png",
  titular:"¿Cuánto vale tu casa",
  claim:"Una valoración on-line en segundos con un rango de precio preciso en venta y alquiler comparando con inmuebles similares",
  link:"#",
  textoLink:"Valorar tu casa gratis"
  }

}
