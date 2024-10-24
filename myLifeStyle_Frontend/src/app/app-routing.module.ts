import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SigninComponent } from './signin/signin.component';
import { DrinkingWaterChartComponent } from './drinkingwater-chart/drinkingwater-chart.component';
import { HoursAtGymChartComponent } from './hoursatgym-chart/hoursatgym-chart.component';
import { KmRunChartComponent } from './kmrun-chart/kmrun-chart.component';
import { RecordComponent } from './record/record.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { MusicComponent } from './music/music.component';
import { DietComponent } from './diet/diet.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent }, 
  { path: 'signin', component: SigninComponent },
  { path: 'home', component: HomeComponent },
  { path: 'drinkingwater-chart', component: DrinkingWaterChartComponent},
  { path: 'hoursatgym-chart', component: HoursAtGymChartComponent},
  { path: 'kmrun-chart', component: KmRunChartComponent},
  { path: 'record', component: RecordComponent},
  { path: 'menu', component: MenuComponent}, 
  { path: 'music', component: MusicComponent},
  { path: 'diet', component: DietComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
