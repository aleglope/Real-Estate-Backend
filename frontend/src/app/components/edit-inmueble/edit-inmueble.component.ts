import { Component, OnInit } from '@angular/core';
import { InmuebleService } from '../../services/inmueble.service';
import { PoblacionService } from '../../services/poblacion.service';
import { TipoService } from '../../services/tipo.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Inmueble, Poblacion, Tipo } from '../../models/entity';

@Component({
  selector: 'app-edit-inmueble',
  templateUrl: './edit-inmueble.component.html',
  styleUrl: './edit-inmueble.component.css',
})
export class EditInmuebleComponent implements OnInit {
  //////////////////////////////////////////////////////
  nFases: number = 3;
  cargaCompletada: boolean = false;
  fasesCargadas: number = 0;
  //////////////////////////////////////////////////////

  id: number;
  aPoblaciones: Poblacion[];
  inmueble: Inmueble;
  aTipos: Tipo[];

  constructor(
    private _inmuebleService: InmuebleService,
    private _poblacionService: PoblacionService,
    private _tipoService: TipoService,
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

    this._inmuebleService.getInmueble(this.id).subscribe({
      next: (datos) => {
        this.inmueble = datos;
      },
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this.faseCarga();
      },
    });

    this._poblacionService.getPoblaciones().subscribe({
      next: (datos) => {
        this.aPoblaciones = datos;
      },
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this.faseCarga();
      },
    });

    this._tipoService.getTipos().subscribe({
      next: (datos) => {
        this.aTipos = datos;
      },
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this.faseCarga();
      },
    });
  }// end getDatos

  edit(): void {
        //CONVERTIMOS LOS BOOLEAN DE LOS CHECKS EN NUMBER
    this.inmueble.activo = +this.inmueble.activo;
    this.inmueble.amueblado = +this.inmueble.amueblado;
    this.inmueble.ascensor = +this.inmueble.ascensor;
    this.inmueble.jardin = +this.inmueble.jardin;
    this.inmueble.piscina = +this.inmueble.piscina;
    this.inmueble.portada = +this.inmueble.portada;
    this.inmueble.tendedero = +this.inmueble.tendedero;
    this.inmueble.trastero = +this.inmueble.trastero;

    this._inmuebleService.updateInmueble(this.inmueble).subscribe({
      next: (datos) => {},
      error: (error) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this._router.navigate(['/list-inmueble']);
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
