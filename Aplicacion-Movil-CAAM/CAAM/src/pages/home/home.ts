import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { IngresoPage } from '../ingreso/ingreso';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {

  }
  //Este metodo sirve para redireccionar a la pagina de Autenticacion del Usuario 
  PaginaIngreso(){
    this.navCtrl.push(IngresoPage);
  }
}
