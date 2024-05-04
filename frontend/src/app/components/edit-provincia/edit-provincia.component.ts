import { Component, OnInit } from '@angular/core';
import { Provincia } from '../../models/entity';
import { ProvinciaService } from '../../services/provincia.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-provincia',
  templateUrl: './edit-provincia.component.html',
  styleUrl: './edit-provincia.component.css',
})
export class EditProvinciaComponent implements OnInit {
  //////////////////////////////////////////////////////
  nFases: number = 1;
  cargaCompletada: boolean = false;
  fasesCargadas: number = 0;
  //////////////////////////////////////////////////////

  id: number;
  /* NO HACE FALTA DETALLAR EL OBJETO PORQUE SE RELLENA EN LA PRIMERA LLAMADA */
  provincia: Provincia;

  constructor(
    private _provinciaService: ProvinciaService,
    private _router: Router,
    private _route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos(): void {
    this._route.params.subscribe({
      next: (params) => {
        this.id = params['id'];
      },
    });

    this._provinciaService.getProvincia(this.id).subscribe({
      next: (datos) => {
        this.provincia = datos;
      },
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this.faseCarga();
      },
    });
  }

  edit(): void {
    this.provincia.activo = Number(this.provincia.activo);
    this.provincia.nombre = this.provincia.nombre.toUpperCase();

    this._provinciaService.updateProvincia(this.provincia).subscribe({
      next: (datos) => {
        this.provincia = datos;
      },
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this._router.navigate(['/list-provincia']);
      },
    });
  }

  /////////////////////////////////////////
  faseCarga(): void {
    this.fasesCargadas++;

    if (this.fasesCargadas == this.nFases) {
      this.cargaCompletada = true;
    }
  }
}
