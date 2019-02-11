import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ElectronicaBasicaPage } from '../electronica-basica/electronica-basica';
import { UsersProvider } from './../../providers/users/users';
import { Http } from '@angular/http';

@IonicPage()
@Component({
  selector: 'page-practica-a-electronica-basica',
  templateUrl: 'practica-a-electronica-basica.html',
})
export class PracticaAElectronicaBasicaPage {
  //declaramos las variables que se usaran para luego registrar la tarea
  //con el consumo REST de tipo POST
  infotalleres
  respuesta : boolean;
  observacion
  resultado
  descripcion
  idpersona
  idnivel
  constructor(public navCtrl: NavController, public navParams: NavParams, public paginaElectronicaBasica:ElectronicaBasicaPage,private userProvider: UsersProvider,public http: Http) {
    //declaramos variables de respuesta y descripcion que en este caso son de tipo estaticos es decir
    //que no se obtiene  de un consumo REST
  this.respuesta = false;
  this.descripcion = "Practica A"
  //Obtenemos variables que contiene la pagina paginaElectronicaBasica que en este caso se transforma
  //en una pagina de tipo Padre
  this.infotalleres = this.paginaElectronicaBasica.datostalleres;
  this.idpersona = this.paginaElectronicaBasica.idusu;
  this.idnivel = this.paginaElectronicaBasica.idnivel;
  }
  //este metodo por defecto nos indica enque pagina nos encontramos en este momento
  //este nos servira para visualizar en la consola
  ionViewDidLoad() {
     console.log("Esta en la Pagina PracticaAElectronicaBasicaPage")
  }
  //metodo de Respuesta que es activado por el boton de realizado de la practica
  //en este metodo recolectamos toda la informacion que luego sera ingresada 
  //por nuestro servicio REST de tip[o POST
  metodoRespuesta(){
    if(this.respuesta==true){
      this.resultado = 1;
    }
    else{
      this.resultado = 0;
    }
    if(this.observacion.length == 0){
      this.observacion="Sin Observacion";
    }
    //usamos el metodo saveRespuesta dde nuestro Provider con este metodo ingresamos los valores de la 
    //practica realizada en nuestro servicio REST de tipo POST
    this.userProvider.saveRespuesta(this.observacion,this.resultado,this.descripcion,this.idnivel,this.idpersona)
  }

}
