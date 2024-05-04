import { Component, OnInit } from '@angular/core';
import { Inmueble, Poblacion, Tipo } from '../../models/entity';
import { PoblacionService } from '../../services/poblacion.service';
import { TipoService } from '../../services/tipo.service';
import { Router } from '@angular/router';
import { InmuebleService } from '../../services/inmueble.service';

@Component({
  selector: 'app-add-inmueble',
  templateUrl: './add-inmueble.component.html',
  styleUrl: './add-inmueble.component.css',
})
export class AddInmuebleComponent implements OnInit {
  ///////////////////////////////////////////////
  nFases: number = 2;
  cargaCompletada: boolean = false;
  fasesCargadas: number = 0;
  ///////////////////////////////////////////////

  aPoblaciones: Poblacion[] = [];
  aTipos: Tipo[] = [];

  inmueble: Inmueble = {
    activo: 1,
    amueblado: 0,
    apertura: '',
    ascensor: 0,
    cp: '',
    descripcion: '',
    jardin: 0,
    nombreVia: '',
    numero: '',
    numeroBalcones: '',
    numeroBanhos: '',
    numeroHabitaciones: '',
    operacion: '',
    orientacion: '',
    piscina: 0,
    planta: '',
    plazasGaraje: '',
    portada: 0,
    precio: 0,
    puerta: '',
    superficieConstruida: '',
    superficieUtil: '',
    tendedero: 0,
    tipoCalefaccion: '',
    titular: '',
    trastero: 0,
    via: '',
    poblacion: {
      nombre: '',
      provincia: {
        nombre: '',
        activo: 0,
      },
      activo: 0,
    },
    tipo: {
      nombre: '',
      activo: 0,
    },
  };

  constructor(
    private _tipoService: TipoService,
    private _poblacionService: PoblacionService,
    private _inmuebleService: InmuebleService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos(): void {
    /* RELLENAMOS EL SELECT POBLACIÓN CON LOS DATOS DE LA BBDD */
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

    /* RELLENAMOS EL SELECT TIPOS CON LOS DATOS DE LA BBDD */
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
  } //end getDatos()

  add(): void {
    //CONVERTIMOS LOS BOOLEAN DE LOS CHECKS EN NUMBER
    this.inmueble.activo = +this.inmueble.activo;
    this.inmueble.amueblado = +this.inmueble.amueblado;
    this.inmueble.ascensor = +this.inmueble.ascensor;
    this.inmueble.jardin = +this.inmueble.jardin;
    this.inmueble.piscina = +this.inmueble.piscina;
    this.inmueble.portada = +this.inmueble.portada;
    this.inmueble.tendedero = +this.inmueble.tendedero;
    this.inmueble.trastero = +this.inmueble.trastero;

    this._inmuebleService.addInmueble(this.inmueble).subscribe({
      next: (datos) => {},
      error: (e) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this._router.navigate(['/list-inmueble']);
      },
    });
  }

  /////////////////////////////////////////////////////
  faseCarga(): void {
    this.fasesCargadas++;

    if (this.fasesCargadas == this.nFases) {
      this.cargaCompletada = true;
    }
  }
  //////////////////////////////////////////////////
}
