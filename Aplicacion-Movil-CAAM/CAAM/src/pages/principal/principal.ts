import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController } from 'ionic-angular';
import { UsersProvider } from './../../providers/users/users';
import { ElectronicaBasicaPage } from '../electronica-basica/electronica-basica';
import { ElectronicaIntermediaPage } from '../electronica-intermedia/electronica-intermedia';
import { HomePage } from '../home/home';


@IonicPage()
@Component({
  selector: 'page-principal',
  templateUrl: 'principal.html',
})
export class PrincipalPage {
model : Ptaller;
datos
dato
talleres
id
persona
nombretotal
idn
idnivel
comentarios
//constructor de nuestra pagina principal
  constructor(public navCtrl: NavController, public navParams: NavParams, public proveedor: UsersProvider,private toast: ToastController) {
   //Aqui recuperamos los datos de nuestro usuario
    this.datos = navParams.get('dato');
      for(var i=0; i < this.datos.length; i++){
        if(this.datos[i]["idPersona"]){
          this.id=this.datos[i]["idPersona"];
          console.log(this.id);
          this.nombretotal=this.datos[i]["nombretotal"];
        }
      }
      //con este metodo loramos listar los talleres a los que pertenece el usuario
      this.proveedor.obtenertalleres(this.id)
      .subscribe(
      (data)=>{this.talleres = data},
      (error)=>{console.log(error);}
    )
    //este metodo muestra en pantalla comentarios de los terapistas 
    //hacia los adultos Mayores en caso de que existiiera un comentario
    //de alguna parctica en especifico
    this.proveedor.obtenercomentarios(this.id).subscribe(
      (datas)=>{this.comentarios = datas,
        console.log(this.comentarios);},
      (error)=>{console.log(error);}
    )
  }
  //metodo por defecto que nos permitira ver en consola en que pagina nos encontramos
  ionViewDidLoad() {
    console.log("Esta en la pagina PrincipalPage");
  }
  //metod en viado por el boton de la Pagina el mismo que envia de modo URL los
  //valores del nombre del taller u su id
  //los mismos que seran uasando para obtener informacion de taller
  //consumiendo un servicio REST de tipo GET
  metodotraigo(datoseleccionado){
     this.idnivel = 1;
     if(datoseleccionado == "Electronica Basica"){
        this.navCtrl.push(ElectronicaBasicaPage,{talleresAll:this.talleres[0],idusu:this.id, idnivel:this.idnivel});
     }
     if(datoseleccionado == "Electronica Intermedia"){
      this.idnivel = 2;
      this.navCtrl.push(ElectronicaIntermediaPage,{talleresAll:this.talleres[1],idusu:this.id, idnivel:this.idnivel});
    }
   }
   //metodo que  os permitira salir de la aplicacion
   exitApp(){
    this.toast.create({message:'Usted acaba de salir del CAAM', position:'botton', duration: 3000}).present(),
     this.navCtrl.setRoot(HomePage);     
   }
   //metodo que permitira actualizar los comentarios a un estado e revisado
   metodoComentarioRevisado(idcomentario, comentario, estado){
      this.proveedor.updateComentarios(idcomentario,comentario,estado);
   }
}
export class Ptaller{
  descripcion: String;
}


