/* The `export interface Inmueble` in the TypeScript code snippet defines a TypeScript interface named
`Inmueble`. An interface in TypeScript is a way to define the shape of an object. In this case, the
`Inmueble` interface describes the structure of a real estate property. */
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

}

/* The `export interface Tipo` in the TypeScript code snippet is defining a TypeScript interface named
`Tipo`. This interface describes the structure of a type of real estate property. It includes three
properties: `id` which is an optional number, `nombre` which is a string representing the name of
the type, and `activo` which is a number indicating whether the type is active or not. By exporting
this interface, it can be used in other parts of the codebase or in other files. */
export interface Tipo{

    id?:number;
    nombre:string;
    activo:number

}

/* The `export interface Poblacion` in the TypeScript code snippet is defining a TypeScript interface
named `Poblacion`. This interface describes the structure of a population or city entity related to
real estate properties. It includes four properties: */
export interface Poblacion{

    id?:number;
    nombre:string;
    provincia:Provincia;
    activo:number

}


/* The `export interface Provincia` in the TypeScript code snippet is defining a TypeScript interface
named `Provincia`. This interface describes the structure of a province entity related to real
estate properties. It includes three properties: `id` which is an optional number representing the
unique identifier of the province, `nombre` which is a string representing the name of the province,
and `activo` which is a number indicating whether the province is active or not. By exporting this
interface, it can be used in other parts of the codebase or in other files. */
export interface Provincia{

    id?:number;
    nombre:string;
    activo:number

}