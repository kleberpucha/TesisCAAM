import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { IngresoPage } from '../pages/ingreso/ingreso';
import { PrincipalPage } from '../pages/principal/principal';
import { HttpClientModule } from '@angular/common/http';
import { UsersProvider } from '../providers/users/users';

import { HttpModule }  from '@angular/http';
import { ElectronicaBasicaPage } from '../pages/electronica-basica/electronica-basica';
import { ElectronicaIntermediaPage } from '../pages/electronica-intermedia/electronica-intermedia';



@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    IngresoPage,
    PrincipalPage,
    ElectronicaBasicaPage,
    ElectronicaIntermediaPage,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    IngresoPage,
    PrincipalPage,
    ElectronicaBasicaPage,
    ElectronicaIntermediaPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    UsersProvider
  ]
})
export class AppModule {}
