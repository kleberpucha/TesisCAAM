import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the PracticaBElectronicaIntermediaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-practica-b-electronica-intermedia',
  templateUrl: 'practica-b-electronica-intermedia.html',
})
export class PracticaBElectronicaIntermediaPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PracticaBElectronicaIntermediaPage');
  }

}
