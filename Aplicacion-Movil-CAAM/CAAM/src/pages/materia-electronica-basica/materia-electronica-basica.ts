import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-materia-electronica-basica',
  templateUrl: 'materia-electronica-basica.html',
})
export class MateriaElectronicaBasicaPage {
//constructor de la pagina del contenido de materia 
  constructor(public navCtrl: NavController, public navParams: NavParams) { }
//este metodo por defecto nos servira en la consola para verificar que nos encontramos
//dentro de pa pagina
  ionViewDidLoad() {
    console.log('Esta en la pagina MateriaElectronicaBasicaPage');
  }
}
