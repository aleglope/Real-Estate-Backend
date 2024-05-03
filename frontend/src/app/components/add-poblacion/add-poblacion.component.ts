import { Component, OnInit } from '@angular/core';
import { ProvinciaService } from '../../services/provincia.service';
import { Router } from '@angular/router';
import { PoblacionService } from '../../services/poblacion.service';
import { Poblacion, Provincia } from '../../models/entity';

@Component({
  selector: 'app-add-poblacion',
  templateUrl: './add-poblacion.component.html',
  styleUrl: './add-poblacion.component.css'
})
export class AddPoblacionComponent implements OnInit {

    ///////////////////////////////////////////////
    nFases:number=1;
    cargaCompletada:boolean=false;
    fasesCargadas:number=0;
    ///////////////////////////////////////////////



  aProvincias:Provincia[];

  constructor(
    private _provinciaService : ProvinciaService,
    private _poblacionService : PoblacionService,
    private _router:Router
  ){}


  ngOnInit(): void {
    this.getDatos();
  }

  poblacion:Poblacion={
    nombre:"",
    provincia:{
      nombre:"",
      activo:0
    },
    activo:1
  }



  getDatos():void{

    this._provinciaService.getProvincias().subscribe({

      next: (datos)=>{
        this.aProvincias = datos;
      }
      ,
      error: (error)=>{this._router.navigate(['/error'])}
      ,
      complete: ()=>{this.faseCarga()}

    });

  }


  add():void{

    this.poblacion.nombre = this.poblacion.nombre.toUpperCase();

    this._poblacionService.addPoblacion(this.poblacion).subscribe({

        next: (datos)=>{}
        ,
        error: (e)=>{this._router.navigate(['/error'])}
        ,
        complete: ()=>{this._router.navigate(['/list-poblacion'])}

    });

  }


  /////////////////////////////////////////////////////
  faseCarga():void{

    this.fasesCargadas++;

    if(this.fasesCargadas == this.nFases){
      this.cargaCompletada = true;
    }
  }
  //////////////////////////////////////////////////


}
