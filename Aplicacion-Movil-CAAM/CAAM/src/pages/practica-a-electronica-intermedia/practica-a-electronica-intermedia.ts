import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UsersProvider } from './../../providers/users/users';
import { Http } from '@angular/http';
import { ElectronicaIntermediaPage } from '../electronica-intermedia/electronica-intermedia';

@IonicPage()
@Component({
  selector: 'page-practica-a-electronica-intermedia',
  templateUrl: 'practica-a-electronica-intermedia.html',
})
export class PracticaAElectronicaIntermediaPage {
    //declaramos las variables que se usaran para luego registrar la tarea
  //con el consumo REST de tipo POST
  infotalleres
  respuesta : boolean;
  observacion
  resultado
  descripcion
  idpersona
  idnivel
  constructor(public navCtrl: NavController, public navParams: NavParams, public paginaElectronicaIntermedia:ElectronicaIntermediaPage,private userProvider: UsersProvider,public http: Http) {
      //declaramos variables de respuesta y descripcion que en este caso son de tipo estaticos es decir
    //que no se obtiene  de un consumo REST

    this.respuesta = false;
    this.descripcion = "Practica A"
    //Obtenemos variables que contiene la pagina paginaElectronicaBasica que en este caso se transforma
    //en una pagina de tipo Padre
    this.infotalleres = this.paginaElectronicaIntermedia.datostalleres;
    this.idpersona = this.paginaElectronicaIntermedia.idusu;
    this.idnivel = this.paginaElectronicaIntermedia.idnivel;
  }

  ionViewDidLoad() {
    console.log('Esta en la pagina PracticaAElectronicaIntermediaPage');
  }
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
