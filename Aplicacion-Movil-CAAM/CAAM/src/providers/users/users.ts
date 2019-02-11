import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';


@Injectable()
export class UsersProvider {
  
  private API_URL = 'https://reqres.in/api/'
  //private api_url ='https://jsonplaceholder.typicode.com'

  //http://192.168.1.150:8080/aCaam/srv/persona/perId?ID=1
  //http://192.168.1.150:8080/aCaam/srv/ObjetoApredizaje/insertarO

  //declaramos la variable que contendra nuestro link del web service
  private api_url_caam='http://35.190.139.136:8080/aCaam/srv/'
  constructor(public http: HttpClient) {
    console.log('Hola esta dentro de su Proveedor');
  }
  //metodo para crear un usuario de tipo POST
  createAccount(email: String, password: String){
    return new Promise((resolve, reject)=>{
      var data = { 
        contrasena: password, usuario: email
      };
      console.log(JSON.stringify(data));
      this.http.post(this.api_url_caam+'insertar', data)
      .subscribe(res=>{
        resolve(res);
      },
      (err)=>{
        reject(err);
      });
    });
  }
  //metodo de login de tipo POST
  login(email: String, password: String){
    console.log('entre al metodo');
    return new Promise((resolve, reject)=>{
      console.log('dentro de return');
      var data = {
        email: email, 
        password: password
      };
      console.log(JSON.stringify(data));
      console.log('paso data');
      this.http.post(this.API_URL + 'login',JSON.stringify(data))
      .subscribe((result: any)=>{
        resolve(result.json());
        console.log('resolvio');
      },
      (error)=>{
        reject(error.json());
        console.log('dio error');
      })
    });
  }

  //metodo para obtener toda una lista de tipo GET
  getAll(page: number){
    return new Promise((resolve, reject)=>{
    let url = this.API_URL + 'users?per_page=10&page=' +page;

      this.http.get(url)
      .subscribe((result: any)=>{
        resolve(result.json());
      },
      (error)=>{
        reject(error.json());
      })
    });
  }
//metodo para obtener un valor de una lista de tipo GET
  get(id: number){
    return new Promise((resolve, reject)=>{
    let url = this.API_URL + 'users/' +id;

      this.http.get(url)
      .subscribe((result: any)=>{
        resolve(result.json());
      },
      (error)=>{
        reject(error.json());
      })
    });
  }
//metodo para insertar de tipo POST
  insert(user: any){
    return new Promise((resolve, reject)=>{
    //let url = this.API_URL + 'users';
    console.log(JSON.stringify(user));
      this.http.post(this.api_url_caam+'ejemplo/insertar', JSON.stringify(user))
      .subscribe((result: any)=>{
        resolve(result.json());
      },
      (error)=>{
        reject(error.json());
      })
    });
  }
//Metodo para actualizar de tipo PUT
  update(user: any){
    return new Promise((resolve, reject)=>{
    let url = this.API_URL + 'users' + user.id;
    let data ={
      "first_name":user.first_name,
      "last_name":user.last_name
    }
      this.http.put(url, data)
      .subscribe((result: any)=>{
        resolve(result.json());
      },
      (error)=>{
        reject(error.json());
      })
    });
  }
//metodo p[ara borrar de tipo DELETE
  remove(id: number){
    return new Promise((resolve, reject)=>{
    let url = this.API_URL + 'users/' + id;

      this.http.delete(url)
      .subscribe((result: any)=>{
        resolve(result.json());
      },
      (error)=>{
        reject(error.json());
      })
    });
  }
//metodo de obtencion de datos de tipo GET
  obtenerdatos(){
    return this.http.get(this.api_url_caam+'ejemlos');
  }
  //metodo para obtener talleres de tipo GET
  obtenertalleres(id: number){
    return this.http.get(this.api_url_caam+'suscripcion/listaSus?int='+id);
  }
  //metodo para obtener informacion de un usuario de tipo GET
  obtenerinfopersona(id: number){
    return this.http.get(this.api_url_caam+'persona/perId?ID='+id);
  }
  //metodo para guardar una tarea realizada de tipo POST
  saveRespuesta(observaciones : String, Resultado : number, tarea: String, idnivel: number, idpersona: number){
    return new Promise((resolve, reject)=>{
      var data = { 
        tarea: tarea,
        observacoiones: observaciones,
        resultado: Resultado,
        persona:{
          personaId: idpersona
        }, 
        nivel:{
          id:idnivel
        }
      };
      console.log(JSON.stringify(data));
      this.http.post(this.api_url_caam+'ObjetoApredizaje/insertarO', data)
      .subscribe(res=>{
        resolve(res);
      },
      (err)=>{
        reject(err);
      });
    });
  }
  //metodo para obtener comentarios
  obtenercomentarios(id: number){
   return this.http.get(this.api_url_caam+'ComentarioServicio/comentariosNo?ID='+id)
  }
  //metodo para ctualizar los comentarios ya leidos
  updateComentarios(ComentarioId : number, Comentario : String, Estado : String){
    return new Promise((resolve, reject)=>{
      var data = {     
           comentarioid: ComentarioId,
           comentario: Comentario,
           estado: Estado
      };
      console.log(JSON.stringify(data));
        
console.log(JSON.stringify(data));
this.http.post(this.api_url_caam+'ComentarioServicio/update', data)
.subscribe(res=>{
  resolve(res);
},
(err)=>{
  reject(err);
});

    });
  }
}
