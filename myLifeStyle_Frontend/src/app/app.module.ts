import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SigninComponent } from './signin/signin.component';
import { LogoutComponent } from './logout/logout.component';
import { Routes } from '@angular/router';
import { AuthInterceptor } from './AuthInterceptor';
import { HoursAtGymChartComponent } from './hoursatgym-chart/hoursatgym-chart.component';
import { KmRunChartComponent } from './kmrun-chart/kmrun-chart.component';
import { DrinkingWaterChartComponent } from './drinkingwater-chart/drinkingwater-chart.component';
import { NgChartsModule } from 'ng2-charts';
import { RecordComponent } from './record/record.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { MusicComponent } from './music/music.component';
import { DietComponent } from './diet/diet.component';
import { ShowallmusicComponent } from './showallmusic/showallmusic.component';
import { ListbygenreComponent } from './listbygenre/listbygenre.component';
import { SearchbyartistComponent } from './searchbyartist/searchbyartist.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SigninComponent,
    LogoutComponent,
    HoursAtGymChartComponent,
    KmRunChartComponent,
    DrinkingWaterChartComponent,
    RecordComponent,
    HomeComponent,
    MenuComponent,
    MusicComponent,
    DietComponent,
    ShowallmusicComponent,
    ListbygenreComponent,
    SearchbyartistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, 
    NgChartsModule, 
    ReactiveFormsModule 
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
