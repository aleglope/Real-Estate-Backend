import { Injectable } from '@angular/core';
import { GLOBAL } from '../environments/global';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tipo } from '../models/entity';

@Injectable({
  providedIn: 'root',
})
export class TipoService {
  url: string = GLOBAL.url;

  constructor(private _http: HttpClient) { }

  getTipos(): Observable<Tipo[]> {
    return this._http.get<Tipo[]>(this.url + 'tipos');
  }

  getTiposActivos(): Observable<Tipo[]> {
    return this._http.get<Tipo[]>(this.url + 'tipos-activos');
  }

  addTipo(tipo: Tipo): Observable<Tipo> {
    return this._http.post<Tipo>(this.url + 'tipo', tipo);
  }

  getTipo(id: number): Observable<Tipo> {
    return this._http.get<Tipo>(this.url + 'tipo/' + id);
  }

  updateTipo(tipo: Tipo): Observable<Tipo> {
    return this._http.put<Tipo>(this.url + 'tipo', tipo);
  }
}
