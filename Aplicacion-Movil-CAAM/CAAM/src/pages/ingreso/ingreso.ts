import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController } from 'ionic-angular';
import { PrincipalPage } from '../principal/principal';
import { Http,Headers,RequestOptions } from '@angular/http'

@IonicPage()
@Component({
  selector: 'page-ingreso',
  templateUrl: 'ingreso.html',
})
export class IngresoPage {
 model : User;
 usuarios
 dato
 //constructor de pagina de ingreso 
  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http,
    private toast: ToastController) {
      //creamos un nuevo usuario para que al momento que usuario no ingrese datos
      //no genere un error de falta de datos 
      this.model = new User();
      this.model.email = '';
      this.model.password ='';
  }
 //metodo para ingresar a la Pagina Principal
  ingresarPrincipal(){
    this.navCtrl.push(PrincipalPage);
  }
 //metodo de login es mismo que resibe parametros como son usuario y contraseña
 //aqui con los datos obtenidos consumimos un resvirio REST de tipo get
  metodoLogin(){
    let cabecera = new Headers({
      'Accept' : 'application/json'
    });
    let opciones = new RequestOptions({headers: cabecera})
    //http://192.168.1.150:8080/acaam/srv/persona/logginaplicacion?usuario=admin&contrasena=admin
     //llamamos al metodo login desde nuestro Provider
    this.http.get('http://35.190.139.136:8080/aCaam/srv/persona/logginAplicacion?usuario='+this.model.email+'&contrasena='+this.model.password,opciones)
    .map(res => res.json())
    .subscribe(datos =>{
      console.log("obtengo toda la informacion de mi rest");
      console.log(datos);
      if (datos.length == 0) {
        this.toast.create({message:'Usuario no Existe o datos ERRONEOS', position:'botton', duration: 3000}).present();
      } else {
        this.toast.create({message:'Hola! Bienvenido al CAAM Virtual', position:'botton', duration: 3000}).present();
        this.dato = datos;
        this.navCtrl.setRoot(PrincipalPage,{dato:datos});
      }
    }), err => {
      console.log(err);
    } 

  }
}
//creamos la clase User para usarlo en el constructor
export class User{
  email: String;
  password: String;
}
