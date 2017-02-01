import { BrowserModule } from '@angular/platform-browser';
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routes";
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {HeaderComponent} from "./header/header.component";
import { AppComponent } from './app.component';
import {CoreModule} from "./core/core.module";
import {HomeModule} from "./pages/home/home.module";
import {SignupModule} from "./pages/signup/signup.module";
import {LoginModule} from "./pages/login/login.module";
import {TopModule} from "./pages/top/top.module";
import {HelpModule} from "./pages/help/help.module";
import {NoContentComponent} from "./pages/no-content/no-content.component";
@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    HeaderComponent,
    NoContentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ROUTES),
    CoreModule,
    HomeModule,
    SignupModule,
    LoginModule,
    TopModule,
    HelpModule,
  ],
  providers: []
})
export class AppModule { }
