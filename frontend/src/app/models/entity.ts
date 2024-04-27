export interface Inmueble{

    id?:number;
    activo:number;
    amueblado:number;
    apertura:string;
    ascensor:number;
    cp:string;
    descripcion:string;
    jardin:number;
    nombreVia:string;
    numero:string;
    numeroBalcones:string;
    numeroBanhos:string;
    numeroHabitaciones:string;
    operacion:string;
    orientacion:string;
    piscina:number;
    planta:string;
    plazasGaraje:string;
    portada:number;
    precio:number;
    puerta:string;
    superficieConstruida:string;
    superficieUtil:string;
    tendedero:number;
    tipoCalefaccion:string;
    titular:string;
    trastero:number;
    via:string;
    poblacion:Poblacion;
    tipo:Tipo
    imagenes:imagen[]

}

export interface imagen{

    id:number;
    nombre:string;
    activo:number
}

export interface Tipo{

    id?:number;
    nombre:string;
    activo:number

}

export interface Poblacion{

    id?:number;
    nombre:string;
    provincia:Provincia;
    activo:number

}


export interface Provincia{

    id?:number;
    nombre:string;
    activo:number

}