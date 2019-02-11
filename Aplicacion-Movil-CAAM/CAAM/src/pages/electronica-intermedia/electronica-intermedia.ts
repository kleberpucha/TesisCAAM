import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav } from 'ionic-angular';
import { UsersProvider } from '../../providers/users/users';

@IonicPage()
@Component({
  selector: 'page-electronica-intermedia',
  templateUrl: 'electronica-intermedia.html',
})
export class ElectronicaIntermediaPage {
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
  rootPage = 'MateriaElectronicaIntermediaPage';
  constructor(public navCtrl: NavController, public navParams: NavParams, public userProvider: UsersProvider) {
       //obtenemos los datos que luego serviran para consumir los servicio
   //Rest ya sea de tipo POST o GET
   this.datostalleres = navParams.get('talleresAll');
   this.idusu = navParams.get('idusu');
  this.idnivel = navParams.get('idnivel');
   //this.idnivel = 2;
   console.log("esta es la informacion que recibo a electronica intermedia");
   console.log(this.datostalleres);
   //creamos una lista de páguinas que contendra este taller
   this.pages=[
     {title: 'Materia', component: 'MateriaElectronicaIntermediaPage'},
     {title: 'Practica A', component: 'PracticaAElectronicaIntermediaPage'},
     {title: 'Practica B', component: 'PracticaBElectronicaIntermediaPage'},
     {title: 'Practica C', component: 'PracticaCElectronicaIntermediaPage'},
   ];
   //usamos el metodo obtenerinfopersona de nuestro Provider
   //con este servicio Obtenemos la informacion del Usuario
   //luego estos valores obtenidos seran utilizados en esta Pagina
   this.userProvider.obtenerinfopersona(this.idusu)
   .subscribe(
   (data)=>{this.usuario = data;
   },
   (error)=>{console.log(error);}
 )
 //usamos el metodo obtenertalleres de nuestro Provider
 //con este servicio Obtenemos toda la informacion del taller que este tomado ese momento
 //luego estos datos seran usados para consumir los servicios de POST
 console.log("Este es el id que viene a Pagina Intermedia");
 console.log(this.idusu);
 this.userProvider.obtenertalleres(this.idusu)
 .subscribe((data)=>{this.talleres = data;
  console.log("este es lo que contiene el taller ");
  console.log(this.talleres);},(error)=>{console.log(error)})
  //this.taller = this.talleres[1];
  }

  ionViewDidLoad() {
    console.log('Esta en la pagina ElectronicaIntermediaPage');
  }
    //con este metodo logramos mantener a nuestra pagina como principal
    openPage(page){
      this.nav.setRoot(page.component,{ openTab: page.openTab });
    }
    exitApp(){
      this.navCtrl.pop();
    }

}
