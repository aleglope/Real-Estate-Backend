import { Component, OnInit } from '@angular/core';
import { InmuebleService } from '../../services/inmueble.service';
import { Inmueble } from '../../models/entity';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-home',
  templateUrl: './list-home.component.html',
  styleUrl: './list-home.component.css'
})
export class ListHomeComponent implements OnInit {

  ///////////////////////////////////////////////
  nFases:number=1;
  cargaCompletada:boolean=false;
  fasesCargadas:number=0;
  ///////////////////////////////////////////////

  aDatos:any[];
  
  constructor(
    private _inmuebleService:InmuebleService,
    private _router:Router
  ){}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos():void{
    
    this._inmuebleService.getInmueblesPortada().subscribe({

        next: (datos) => { 
          //console.log(datos);
          this.aDatos = datos;
          
        }
        ,
        error: (e)=>{this._router.navigate(['/error'])}
        ,
        complete:() => {this.faseCarga();}

    });

  }


  


  /////////////////////////////////////////////////////
  faseCarga():void{

    this.fasesCargadas++;

    if(this.fasesCargadas == this.nFases){
      this.cargaCompletada = true;
    }
  ////////////////////////////////////////////////////

  }


}
