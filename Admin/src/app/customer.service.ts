import { Injectable } from '@angular/core';
import {Http,Headers} from "@angular/http";
import 'rxjs/add/operator/map';

const BASE_URL='http://localhost:8080/customers';
const header={headers:new Headers({'Content-Type':'application/json'})}
const header1 = { headers: new Headers({'Content-Type': 'application/json' , 'Accept': 'q=0.8;application/json;q=0.9'})};


@Injectable()
export class CustomerService {

  constructor(private http:Http){}

  postData(data){
    return this.http.post(BASE_URL,data,header);//.map(res=>res.json());
  }

  loadData(){
    console.log(BASE_URL);
    return this.http.get(BASE_URL)
      .map(res=>res.json())
  }

  deleteData(id){
    return this.http.delete(BASE_URL+"/"+id,header).map(res=>res.json());

  }
  setBalance(id,amount){
    let data={
      uniqueId:id,
      balance:amount
    }
    return this.http.patch(BASE_URL,data,header);

  }

}
