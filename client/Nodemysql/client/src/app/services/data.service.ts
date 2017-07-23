import { Injectable } from '@angular/core';
import { Http,Headers} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {

  constructor(private http:Http) {
    console.log("Data Service Implemented");
  }

  getData(){
    return this.http.get('http://localhost:4500/data')
      .map( res => res.json());
  }

}
