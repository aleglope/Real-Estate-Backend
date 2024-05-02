import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { MenuPrincipalComponent } from './components/menu-principal/menu-principal.component';
import { FooterComponent } from './components/footer/footer.component';
import { CarouselHomeComponent } from './components/carousel-home/carousel-home.component';
import { CabeceraFooterComponent } from './components/cabecera-footer/cabecera-footer.component';
import { MenuFooterComponent } from './components/menu-footer/menu-footer.component';
import { PieFooterComponent } from './components/pie-footer/pie-footer.component';
import { HomeComponent } from './components/home/home.component';
import { ErrorComponent } from './components/error/error.component';
import { ListHomeComponent } from './components/list-home/list-home.component';
import { BannerHorizontalComponent } from './components/banner-horizontal/banner-horizontal.component';
import { FinderComponent } from './components/finder/finder.component';
import { FichaInmuebleComponent } from './components/ficha-inmueble/ficha-inmueble.component';
import { CarouselFichaComponent } from './components/carousel-ficha/carousel-ficha.component';
import { NoImageDirective } from './directives/no-image.directive';
import { EurosPipe } from './pipes/euros.pipe';
import { AddTipoComponent } from './components/add-tipo/add-tipo.component';
import { PreloaderComponent } from './components/preloader/preloader.component';
import { FormsModule } from '@angular/forms';
import { ListTipoComponent } from './components/list-tipo/list-tipo.component';
import { EditTipoComponent } from './components/edit-tipo/edit-tipo.component';
import { AddProvinciaComponent } from './components/add-provincia/add-provincia.component';
import { EditProvinciaComponent } from './components/edit-provincia/edit-provincia.component';
import { ListProvinciaComponent } from './components/list-provincia/list-provincia.component';
import { AddPoblacionComponent } from './components/add-poblacion/add-poblacion.component';
import { ListPoblacionComponent } from './components/list-poblacion/list-poblacion.component';
import { EditPoblacionComponent } from './components/edit-poblacion/edit-poblacion.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuPrincipalComponent,
    FooterComponent,
    CarouselHomeComponent,
    CabeceraFooterComponent,
    MenuFooterComponent,
    PieFooterComponent,
    HomeComponent,
    ErrorComponent,
    ListHomeComponent,
    BannerHorizontalComponent,
    FinderComponent,
    FichaInmuebleComponent,
    CarouselFichaComponent,
    NoImageDirective,
    EurosPipe,
    ListTipoComponent,
    AddTipoComponent,
    PreloaderComponent,
    EditTipoComponent,
    AddProvinciaComponent,
    EditProvinciaComponent,
    ListProvinciaComponent,
    AddPoblacionComponent,
    ListPoblacionComponent,
    EditPoblacionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
