import { Component } from '@angular/core';
import { ProvinciaService } from '../../services/provincia.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-provincia',
  templateUrl: './list-provincia.component.html',
  styleUrl: './list-provincia.component.css'
})
export class ListProvinciaComponent {

    ///////////////////////////////////////////////
    nFases:number=1;
    cargaCompletada:boolean=false;
    fasesCargadas:number=0;
    ///////////////////////////////////////////////

    aDatos:any[];

    constructor(
      private _provinciaService:ProvinciaService,
      private _router:Router
    ){}



  ngOnInit(): void {
    this.getDatos();
  }


getDatos():void{

  this._provinciaService.getProvincias().subscribe({

    next: (datos)=>{

      this.aDatos = datos;
    }
    ,
    error: (e)=>{this._router.navigate(['/error'])}
    ,
    complete: ()=>{this.faseCarga()}

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

