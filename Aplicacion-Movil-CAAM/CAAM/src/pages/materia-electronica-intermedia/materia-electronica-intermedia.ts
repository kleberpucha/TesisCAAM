import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-materia-electronica-intermedia',
  templateUrl: 'materia-electronica-intermedia.html',
})
export class MateriaElectronicaIntermediaPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {}

  ionViewDidLoad() {
    console.log('ionViewDidLoad MateriaElectronicaIntermediaPage');
  }

}
