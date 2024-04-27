import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from '../environments/global';
import { Inmueble } from '../models/entity';

@Injectable({
  providedIn: 'root'
})
export class InmuebleService {

  url:string=GLOBAL.url;

  constructor(

    private _http:HttpClient

  ) { }

  /* PARA LA PORTADA*/
  getInmueblesPortada():Observable<any[]>{

    return this._http.get<any[]>(this.url + "inmuebles-portada");

  }


}
