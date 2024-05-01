import { Injectable } from '@angular/core';
import { GLOBAL } from '../environments/global';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tipo } from '../models/entity';

@Injectable({
  providedIn: 'root'
})
export class TipoService {

  
  url:string=GLOBAL.url;
  
  constructor(

    private _http:HttpClient

  ) { }


  getTipos():Observable<any[]>{

    return this._http.get<any[]>(this.url + "tipos");

  }

  addTipo(tipo:Tipo):Observable<Tipo>{

    return this._http.post<Tipo>(this.url + "tipo",tipo);

  }


}
