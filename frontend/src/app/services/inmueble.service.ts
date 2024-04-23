import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from '../environments/global';

@Injectable({
  providedIn: 'root'
})
export class InmuebleService {

  url:string=GLOBAL.url;
  
  constructor(

    private _http:HttpClient

  ) { }


  getInmueblesPortada():Observable<any>{

    return this._http.get(this.url + "inmuebles-portada");

  }


}
