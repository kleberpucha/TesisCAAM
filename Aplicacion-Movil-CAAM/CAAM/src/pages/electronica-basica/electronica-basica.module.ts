import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ElectronicaBasicaPage } from './electronica-basica';

@NgModule({
  declarations: [
    ElectronicaBasicaPage,
  ],
  imports: [
    IonicPageModule.forChild(ElectronicaBasicaPage),
  ],
})
export class ElectronicaBasicaPageModule {}
