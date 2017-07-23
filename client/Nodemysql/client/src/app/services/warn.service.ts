import { Injectable } from '@angular/core';
import { Http,Headers} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class WarnService {

  constructor(private http:Http) {
    console.log("Warn Service Implemented");
  }

  getWarnings(){
    return this.http.get('http://localhost:4500/warn')
      .map( res => res.json());
  }

}
