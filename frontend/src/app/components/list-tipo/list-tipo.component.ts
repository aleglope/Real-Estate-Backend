import { Component, OnInit } from '@angular/core';
import { TipoService } from '../../services/tipo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-tipo',
  templateUrl: './list-tipo.component.html',
  styleUrl: './list-tipo.component.css',
})
export class ListTipoComponent implements OnInit {
  ///////////////////////////////////////////////
  nFases: number = 1;
  cargaCompletada: boolean = false;
  fasesCargadas: number = 0;
  ///////////////////////////////////////////////

  aDatos: any[];

  constructor(private _tipoService: TipoService, private _router: Router) {}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos(): void {
    this._tipoService.getTipos().subscribe({
      next: (datos) => {
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
