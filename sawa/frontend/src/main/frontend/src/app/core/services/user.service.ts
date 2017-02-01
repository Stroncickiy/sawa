import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {User} from "../domains";
import {objToSearchParams} from "./helpers";
import {UserParams} from "../dto";
import {MyHttp} from "../http/http";

const url = '/api/users';

@Injectable()
export class UserService {

  constructor(private http:MyHttp) {
  }


  get(id:string|number):Observable<User> {
    return this.http.get(`${url}/${id}`)
      .map(res => res.json());
  }

  create(params:UserParams):Observable<Response> {
    return this.http.post(url, params);
  }

  updateMe(userParam:UserParams):Observable<Response> {
    return this.http.patch(`${url}/me`, userParam)
      .do(resp => {
        localStorage.setItem('jwt', resp.headers.get('x-auth-token'));
      });
  }

}
