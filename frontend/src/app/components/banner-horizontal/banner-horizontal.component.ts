import { Component, Input } from '@angular/core';
import { BannerHorizontal } from '../../models/utils';

@Component({
  selector: 'app-banner-horizontal',
  templateUrl: './banner-horizontal.component.html',
  styleUrl: './banner-horizontal.component.css',
})
export class BannerHorizontalComponent {
  /* @Input() altImagen:string;
  @Input() imagen:string;
  @Input() titular:string;
  @Input() claim:string;
  @Input() link:string;
  @Input() textoLink:string; */

  @Input() datos: BannerHorizontal;
}
