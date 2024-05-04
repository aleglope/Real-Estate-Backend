import { Component, OnInit } from '@angular/core';
import { Poblacion, Provincia } from '../../models/entity';
import { PoblacionService } from '../../services/poblacion.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProvinciaService } from '../../services/provincia.service';

@Component({
  selector: 'app-edit-poblacion',
  templateUrl: './edit-poblacion.component.html',
  styleUrl: './edit-poblacion.component.css',
})
export class EditPoblacionComponent implements OnInit {
  //////////////////////////////////////////////////////
  nFases: number = 2;
  cargaCompletada: boolean = false;
  fasesCargadas: number = 0;
  //////////////////////////////////////////////////////

  id: number;
  aProvincias: Provincia[];
  poblacion: Poblacion;

  constructor(
    private _poblacionService: PoblacionService,
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

    this._poblacionService.getPoblacion(this.id).subscribe({
      next: (datos) => {
        this.poblacion = datos;
      },
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this.faseCarga();
      },
    });

    this._provinciaService.getProvincias().subscribe({
      next: (datos) => {
        this.aProvincias = datos;
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
    this.poblacion.activo = Number(this.poblacion.activo);
    this.poblacion.nombre = this.poblacion.nombre.toUpperCase();

    this._poblacionService.updatePoblacion(this.poblacion).subscribe({
      next: (datos) => {},
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this._router.navigate(['/list-poblacion']);
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
