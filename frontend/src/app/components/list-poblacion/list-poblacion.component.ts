import { Component, OnInit } from '@angular/core';
import { PoblacionService } from '../../services/poblacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-poblacion',
  templateUrl: './list-poblacion.component.html',
  styleUrl: './list-poblacion.component.css',
})
export class ListPoblacionComponent implements OnInit {
  ///////////////////////////////////////////////
  nFases: number = 1;
  cargaCompletada: boolean = false;
  fasesCargadas: number = 0;
  ///////////////////////////////////////////////

  aDatos: any[];

  constructor(
    private _poblacionService: PoblacionService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos(): void {
    this._poblacionService.getPoblaciones().subscribe({
      next: (datos) => {
        //console.log(datos);
        this.aDatos = datos;
      },
      error: (e) => {
        this._router.navigate(['/error']);
      },
      complete: () => {
        this.faseCarga();
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
