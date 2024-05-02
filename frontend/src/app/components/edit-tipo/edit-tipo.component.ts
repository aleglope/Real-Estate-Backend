import { Component, OnInit } from '@angular/core';
import { Tipo } from '../../models/entity';
import { TipoService } from '../../services/tipo.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-tipo',
  templateUrl: './edit-tipo.component.html',
  styleUrl: './edit-tipo.component.css'
})
export class EditTipoComponent implements OnInit {

  //////////////////////////////////////////////////////
  nFases:number=1;
  cargaCompletada:boolean=false;
  fasesCargadas:number=0;
  //////////////////////////////////////////////////////

  id:number;
  tipo:Tipo;


  constructor(
    private _tipoService : TipoService,
    private _router:Router,
    private _route:ActivatedRoute
  ) { }


  ngOnInit():void {
    this.getDatos();
  }




  getDatos():void{

    this._route.params.subscribe({

      next: (params)=>{
        this.id=params['id'];
      }
    });

    this._tipoService.getTipo(this.id).subscribe({

      next: (datos)=>{
        this.tipo=datos;
      }
      ,
        error: (error)=>{this._router.navigate(['/error'])}
      ,
        complete: ()=>{this.faseCarga()}
    });

  }


  edit():void{

    this.tipo.activo = Number(this.tipo.activo);
    this.tipo.nombre = this.tipo.nombre.toUpperCase();

    this._tipoService.updateTipo(this.tipo).subscribe({

      next: (datos)=>{

        this.tipo=datos;
      }
      ,
        error: (error)=>{this._router.navigate(['/error'])}
      ,
        complete: ()=>{this._router.navigate(['/list-tipo'])}
      });
  }

  /////////////////////////////////////////
  faseCarga():void{

    this.fasesCargadas++;

    if(this.fasesCargadas==this.nFases){
      this.cargaCompletada=true;
      }
    }
  }
