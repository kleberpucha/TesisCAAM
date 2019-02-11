import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the PracticaCElectronicaIntermediaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-practica-c-electronica-intermedia',
  templateUrl: 'practica-c-electronica-intermedia.html',
})
export class PracticaCElectronicaIntermediaPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PracticaCElectronicaIntermediaPage');
  }

}
