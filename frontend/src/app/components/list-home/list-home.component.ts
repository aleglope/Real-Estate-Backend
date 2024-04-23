import { Component, OnInit } from '@angular/core';
import { InmuebleService } from '../../services/inmueble.service';

@Component({
  selector: 'app-list-home',
  templateUrl: './list-home.component.html',
  styleUrl: './list-home.component.css'
})
export class ListHomeComponent implements OnInit {

  
  constructor(
    private _inmuebleService:InmuebleService
  ){}

  ngOnInit(): void {
    this.getDatos();
  }

  getDatos():void{
    
  //this._inmuebleService.getInmueblesPortada()

  }


}
