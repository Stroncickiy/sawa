import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core/src/metadata/ng_module";
import {SkipSelf, Optional} from "@angular/core";
import {HttpErrorHandler} from "./services/http-error-handler";
import {LoginService} from "./services/login.service";
import {UserService} from "./services/user.service";
import {PrivatePageGuard} from "./services/private-page.guard";
import {PublicPageGuard} from "./services/public-page.guard";
import {MyHttp} from "./http/http";
import {XHRBackend, Http, RequestOptions, HttpModule} from "@angular/http";
import {ProfileDataResolver} from "./services/profile-data.resolver";
export function myHttpInstance(xhrBackend: XHRBackend, requestOptions: RequestOptions) {
   const ngHttp = new Http(xhrBackend, requestOptions);
   return new MyHttp(ngHttp);
}
@NgModule({
  imports: [
    CommonModule,
    HttpModule,
  ],
  declarations: [],
  exports: [],
  providers: [
    {
      provide: MyHttp,
      useFactory: myHttpInstance,
      deps: [XHRBackend, RequestOptions]
    },
    HttpErrorHandler,
    LoginService,
    UserService,
    ProfileDataResolver,
    PrivatePageGuard,
    PublicPageGuard,
  ]
})
export class CoreModule {

  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only');
    }
  }

  

}
