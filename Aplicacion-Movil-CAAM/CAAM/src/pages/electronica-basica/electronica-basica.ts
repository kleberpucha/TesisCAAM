import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav } from 'ionic-angular';
import { UsersProvider } from '../../providers/users/users';



@IonicPage()
@Component({
  selector: 'page-electronica-basica',
  templateUrl: 'electronica-basica.html',
})
export class ElectronicaBasicaPage {
  //Declaracion de variables.
  datostalleres
  talleres
  usuario
  id
  idusu
 taller
 idnivel
  @ViewChild(Nav) nav: Nav;
  pages: Array<{title: string, component: string, openTab?: any}>;
  rootPage = 'MateriaElectronicaBasicaPage';
  constructor(public navCtrl: NavController, public navParams: NavParams, public userProvider: UsersProvider) {
   //obtenemos los datos que luego serviran para consumir los servicio
   //Rest ya sea de tipo POST o GET

   this.datostalleres = navParams.get('talleresAll');
    this.idusu = navParams.get('idusu');
    this.idnivel = navParams.get('idnivel');
    //this.idnivel = 1;
    console.log("esta es la informacion que recibo");
    console.log(this.datostalleres);
    //creamos una lista de páguinas que contendra este taller
    this.pages=[
      {title: 'Materia', component: 'MateriaElectronicaBasicaPage'},
      {title: 'Practica A', component: 'PracticaAElectronicaBasicaPage'},
      {title: 'Practica B', component: 'PracticaBElectronicaBasicaPage'},
      {title: 'Practica C', component: 'PracticaCElectronicaBasicaPage'},
    ];
    //usamos el metodo obtenerinfopersona de nuestro Provider
    //con este servicio Obtenemos la informacion del Usuario
    //luego estos valores obtenidos seran utilizados en esta Pagina
    this.userProvider.obtenerinfopersona(this.idusu)
    .subscribe(
    (data)=>{this.usuario = data
    },
    (error)=>{console.log(error);}
  )
  //usamos el metodo obtenertalleres de nuestro Provider
  //con este servicio Obtenemos toda la informacion del taller que este tomado ese momento
  //luego estos datos seran usados para consumir los servicios de POST
  console.log("Este es el id que viene a Pagina Intermedia");
  console.log(this.idusu);
  console.log(this.idnivel);
  this.userProvider.obtenertalleres(this.idusu)
  .subscribe((datas)=>{this.talleres = datas;},(error)=>{console.log(error)})
  }
  //Este metodo es por defecto y nos servida de indicador en la consola para verificar
  //que nos encontramos en esta pagina
  ionViewDidLoad() {
    console.log('Esta en la pagina ElectronicaBasicaPage');
  }
  //con este metodo logramos mantener a nuestra pagina como principal
  openPage(page){
    this.nav.setRoot(page.component,{ openTab: page.openTab });
  }
  exitApp(){
    this.navCtrl.pop();
  }
}
