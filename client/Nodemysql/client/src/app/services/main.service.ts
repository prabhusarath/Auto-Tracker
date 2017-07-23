import { Injectable } from '@angular/core';
import { Http,Headers} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class MainService {

  constructor(private http:Http) {
    console.log("Main Service Implemented");
  }

  getVehicle(){
    return this.http.get('http://localhost:4500/main')
      .map( res => res.json());
  }

}
