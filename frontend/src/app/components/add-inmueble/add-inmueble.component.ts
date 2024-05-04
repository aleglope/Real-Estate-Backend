import { Component, OnInit } from '@angular/core';
import { Inmueble, Poblacion, Tipo } from '../../models/entity';
import { PoblacionService } from '../../services/poblacion.service';
import { TipoService } from '../../services/tipo.service';
import { Router } from '@angular/router';
import { InmuebleService } from '../../services/inmueble.service';
import { ToastrService } from 'ngx-toastr';
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
    private poblacionService: PoblacionService,
    private tipoService: TipoService,
    private inmuebleService: InmuebleService,
    private router: Router,
    private toastr: ToastrService  // Inject ToastrService
  ) {}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos(): void {
    this.poblacionService.getPoblaciones().subscribe({
      next: (datos) => {
        this.aPoblaciones = datos;
        this.faseCarga();
      },
      error: (error) => {
        this.toastr.error('Error al cargar las poblaciones. Por favor, inténtelo de nuevo más tarde.');
        this.router.navigate(['/error']);
      }
    });

    this.tipoService.getTipos().subscribe({
      next: (datos) => {
        this.aTipos = datos;
        this.faseCarga();
      },
      error: (error) => {
        this.toastr.error('Error al cargar los tipos. Por favor, inténtelo de nuevo más tarde.');
        this.router.navigate(['/error']);
      }
    });
  }

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


      this.inmuebleService.addInmueble(this.inmueble).subscribe({
        next: () => {
          this.toastr.success('Inmueble añadido con éxito');
          this.router.navigate(['/list-inmueble']);
        },
        error: () => {
          this.toastr.error('Error al añadir el inmueble. Inténtelo de nuevo más tarde.');
          this.router.navigate(['/error']);
        }
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
