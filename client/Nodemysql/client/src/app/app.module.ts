import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { WarnComponent } from './components/warn/warn.component';
import { MainComponent } from './components/main/main.component';
import { DataComponent } from './components/data/data.component';

const appRoutes: Routes = [
  {path:'main',component:MainComponent},
  {path:'data',component:DataComponent},
  {path:'warn',component:WarnComponent}
]




@NgModule({
  declarations: [
    AppComponent,
    WarnComponent,
    MainComponent,
    DataComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
